import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(stack.empty())
                        return false;
                    char tmp = stack.pop();
                    if (tmp != '(')
                        return false;
                    break;
                case ']':
                    if(stack.empty())
                        return false;
                    tmp = stack.pop();
                    if (tmp != '[')
                        return false;
                    break;
                case '}':
                    if(stack.empty())
                        return false;
                    tmp = stack.pop();
                    if (tmp != '{')
                        return false;
                    break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
}
