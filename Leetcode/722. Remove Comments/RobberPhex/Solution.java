import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>(source.length);
        boolean inCommentBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inCommentBlock) {
                    if (line.charAt(i) == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        inCommentBlock = false;
                        i++;
                    }
                } else {
                    if (line.charAt(i) == '/' && i + 1 < line.length()) {
                        if (line.charAt(i + 1) == '/') {
                            i++;
                            break;
                        } else if (line.charAt(i + 1) == '*') {
                            i++;
                            inCommentBlock = true;
                        } else {
                            sb.append(line.charAt(i));
                        }
                    } else {
                        sb.append(line.charAt(i));
                    }
                }
            }
            if (!inCommentBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] source = new String[]{
                "a/*comment", "line", "more_comment*/b"
        };
        for (String line : source) {
            System.out.println(line);
        }

        System.out.println("-----------");

        List<String> res = new Solution().removeComments(source);
        for (String line : res) {
            System.out.println(line);
        }
    }
}