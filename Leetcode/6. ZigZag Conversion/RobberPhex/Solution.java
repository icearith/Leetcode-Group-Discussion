class Solution {
    public String convert(String s, int numRows) {
        int totalStep = 2 * (numRows - 1);
        if (numRows == 1)
            totalStep = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                index += (totalStep - i * 2);
                if (i == 0)
                    continue;
                if (i == numRows - 1) {
                    index += totalStep;
                } else if (index < s.length()) {
                    sb.append(s.charAt(index));
                    index += i * 2;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res;
        res= solution.convert("PAYPALISHIRING", 4);
        System.out.println(res.equals("PINALSIGYAHRPI"));
        res = solution.convert("A", 1);
        System.out.println(res);
    }
}
