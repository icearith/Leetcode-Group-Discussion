/*
 * 这个实际上是后来才抄出来的二分法
 * 但是居然比原来慢，所以我只能将原来的放在后面了。。 
 */
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            max = Math.max(max, piles[i]);
        }
        int min = (int) ((sum + H - 1) / H);
        while (min < max) {
            int mid = (min + max) / 2;
            if (possible(piles, mid, H))
                max = mid;
            else
                min = mid + 1;
        }
        return max;
    }

    private boolean possible(int[] piles, int speed, int H) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] + speed - 1) / speed;
        }
        if (hours <= H)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        System.out.println(res);
        res = new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        System.out.println(res);
        res = new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
        System.out.println(res);
    }
}
