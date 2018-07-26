class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int rindex = 0, carry = 0;
        for (; rindex < b.length(); rindex++) {
            int num = (a.charAt(a.length() - rindex - 1) - '0') + (b.charAt(b.length() - rindex - 1) - '0') + carry;
            carry = num / 2;
            sb.append(num % 2);
        }
        for (; rindex < a.length(); rindex++) {
            int num = (a.charAt(a.length() - rindex - 1) - '0') + carry;
            carry = num / 2;
            sb.append(num % 2);
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res;
        Solution solution = new Solution();

        res = solution.addBinary("11", "111");
        System.out.println(res);
    }
}
