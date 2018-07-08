class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int pair = 0;
        while (x > pair) {
            pair *= 10;
            pair += (x % 10);
            x /= 10;
        }
        return x == pair || x == pair / 10;
    }

    public static void main(String[] args) {
        boolean res = new Solution().isPalindrome(121);
        System.out.println(res);
        res = new Solution().isPalindrome(1221);
        System.out.println(res);
        res = new Solution().isPalindrome(10);
        System.out.println(res);
    }
}
