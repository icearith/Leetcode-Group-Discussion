class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++)
            sum += piles[i];
        int min = (int) (sum / H);
        if (1L * min * H < sum)
            min++;

        while (true) {
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + min - 1) / min;
            }
            if (hours <= H)
                return min;
            min++;
        }
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        System.out.println(res);
        res = new Solution().minEatingSpeed(new int[]{30,11,23,4,20}, 5);
        System.out.println(res);
        res = new Solution().minEatingSpeed(new int[]{30,11,23,4,20}, 6);
        System.out.println(res);
    }
}
