import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        boolean oddFound = false;
        int pairs = 0;
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : chars.entrySet()) {
            int count = e.getValue();
            if (count % 2 == 1) oddFound = true;
            pairs += count / 2;
        }
        return pairs * 2 + (oddFound ? 1 : 0);
    }
}