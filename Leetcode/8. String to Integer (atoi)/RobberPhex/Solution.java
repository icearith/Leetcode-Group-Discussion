class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        long res = 0;
        boolean found = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                if (found)
                    break;
                sign = -1;
                found = true;
            } else if (str.charAt(i) == '+') {
                if (found)
                    break;
                sign = 1;
                found = true;
            } else if (Character.isSpaceChar(str.charAt(i))) {
                if (found) {
                    break;
                }
            } else if (!Character.isDigit(str.charAt(i)))
                break;
            else if (Character.isDigit(str.charAt(i))) {
                found = true;
                res *= 10;
                res += (str.charAt(i) - '0');
                if (res * sign > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if (res * sign < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }
        return (int) (res * sign);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("0-1"));
        System.out.println(solution.myAtoi("   +0 123"));
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
    }
}
