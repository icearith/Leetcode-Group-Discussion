class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() < numRows)
            return s;
        int totalStep = 2 * (numRows - 1);
        char[] retChars = new char[s.length()];
        int index = 0;

        for (int i = 0; i < numRows; i++) {
            int step = totalStep - 2 * i;
            for (int j = i; j < s.length(); j += totalStep) {
                retChars[index++] = s.charAt(j);
                if (step > 0 && step < totalStep && j + step < s.length()) {
                    retChars[index++] = s.charAt(j + step);
                }
            }
        }
        return new String(retChars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res;
        res = solution.convert("PAYPALISHIRING", 4);
        System.out.println(res.equals("PINALSIGYAHRPI"));
        res = solution.convert("A", 1);
        System.out.println(res);
    }
}
