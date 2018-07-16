import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int cur = 0;
        int curDistance = startFuel;
        int reFuel = 0;
        while (curDistance < target) {
            while (cur < stations.length && stations[cur][0] <= curDistance) {
                pq.offer(stations[cur][1]);
                cur++;
            }
            // 得到最大的加油站
            if (pq.isEmpty())
                return -1;
            curDistance += pq.poll();
            reFuel += 1;
        }
        return reFuel;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(1, 1, new int[0][0]));
        System.out.println(solution.minRefuelStops(100, 50, new int[][]{
                new int[]{25, 25},
                new int[]{50, 50},
        }));
        System.out.println(solution.minRefuelStops(100, 25, new int[][]{
                new int[]{25, 25},
                new int[]{50, 25},
                new int[]{75, 25},
        }));
    }
}
