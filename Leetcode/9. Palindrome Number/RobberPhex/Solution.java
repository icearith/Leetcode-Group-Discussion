class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int tmp = x;
        int pair = 0;
        while (tmp > 0) {
            pair *=10;
            pair += (tmp % 10);
            tmp /= 10;
        }
        return x == pair;
    }

    public static void main(String[] args) {
        boolean res = new Solution().isPalindrome(121);
        System.out.println(res);
        res = new Solution().isPalindrome(-121);
        System.out.println(res);
        res = new Solution().isPalindrome(10);
        System.out.println(res);
    }
}
