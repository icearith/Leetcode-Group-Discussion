class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            char cur = prev.charAt(0);
            int curcnt = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == cur) {
                    curcnt++;
                } else {
                    sb.append(curcnt);
                    sb.append(cur);
                    cur = prev.charAt(j);
                    curcnt = 1;
                }
            }
            sb.append(curcnt);
            sb.append(cur);
            prev = sb.toString();
            sb = new StringBuilder();
        }
        return prev;
    }

    public static void main(String[] args) {
        String res;
        res = new Solution().countAndSay(1);
        System.out.println(res);
        res = new Solution().countAndSay(4);
        System.out.println(res);
        res = new Solution().countAndSay(5);
        System.out.println(res);
    }
}
