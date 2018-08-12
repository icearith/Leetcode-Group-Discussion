import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class Worker implements Comparable<Worker> {
        private double rate = -1;
        public final int quality;
        public final int wage;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }

        public double rate() {
            if (rate < 0)
                rate = (double) wage / quality;
            return rate;
        }

        @Override
        public int compareTo(Worker o) {
            if (this.rate() == o.rate())
                return 0;
            if (this.rate() > o.rate())
                return 1;
            return -1;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker workers[] = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        PriorityQueue<Integer> qq = new PriorityQueue<Integer>(K);
        int sum = 0;
        double ret = Double.MAX_VALUE;
        for (Worker worker : workers) {
            qq.add(-worker.quality);
            sum += worker.quality;
            if (qq.size() > K) {
                sum += qq.poll();
            }
            if (qq.size() == K) {
                ret = Math.min(ret, sum * worker.rate());
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double res;
        res = solution.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2);
        System.out.println(res);
        res = solution.mincostToHireWorkers(new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7}, 3);
        System.out.println(res);
    }
}
