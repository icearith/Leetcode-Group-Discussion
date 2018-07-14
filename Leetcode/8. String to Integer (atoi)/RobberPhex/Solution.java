class Solution {
    public int myAtoi(String str) {
        int cur = 0;
        int sign = 1;
        long res = 0;
        while (cur < str.length()) {
            if (str.charAt(cur) != ' ')
                break;
            cur++;
        }
        if (cur >= str.length())
            return 0;
        if (str.charAt(cur) == '-') {
            sign = -1;
            cur++;
        } else if (str.charAt(cur) == '+') {
            sign = 1;
            cur++;
        }
        while (cur < str.length()) {
            if (!Character.isDigit(str.charAt(cur)))
                break;
            res *= 10;
            res += (str.charAt(cur) - '0');
            if(res>Integer.MAX_VALUE){
                if(sign>0){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            cur++;
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
