import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        char[] chars = formula.toCharArray();
        Map<String, Integer> cur = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        for (int i = 0; i < chars.length; ) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(cur);
                cur = new TreeMap<>();
                i++;
            } else if (ch == ')') {
                Map<String, Integer> tmp = cur;
                cur = stack.pop();

                int q = 0;
                i++;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    q *= 10;
                    q += (chars[i] - '0');
                    i++;
                }
                for (String atom : tmp.keySet()) {
                    int atomNum = tmp.get(atom) * q + cur.getOrDefault(atom, 0);
                    cur.put(atom, atomNum);
                }
            } else {
                String atom = String.valueOf(chars[i]);
                i++;
                while (i < chars.length && Character.isLowerCase(chars[i])) {
                    atom += chars[i];
                    i++;
                }
                int q = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    q *= 10;
                    q += (chars[i] - '0');
                    i++;
                }
                if (q == 0)
                    q = 1;
                cur.put(atom, q + cur.getOrDefault(atom, 0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String atom : cur.keySet()) {
            sb.append(atom);
            int q = cur.get(atom);
            if (q > 1)
                sb.append(q);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ret = new Solution().countOfAtoms("K4(ON(SO3)2)2");
        System.out.println(ret);
    }
}