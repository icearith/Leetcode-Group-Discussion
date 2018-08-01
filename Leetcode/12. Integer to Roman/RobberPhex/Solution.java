import java.util.HashMap;
import java.util.Map;

class Solution {
    private static Map<Integer, String> map;
    private static int[] keys;

    static {
        map = new HashMap<>();

        map.put(1, "I");

        map.put(5, "V");
        map.put(4, "IV");

        map.put(10, "X");
        map.put(9, "IX");

        map.put(50, "L");
        map.put(40, "XL");

        map.put(100, "C");
        map.put(90, "XC");

        map.put(500, "D");
        map.put(400, "CD");

        map.put(1000, "M");
        map.put(900, "CM");

        keys = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int l = 0, r = keys.length - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (keys[mid] <= num) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            sb.append(map.get(keys[l]));
            num -= keys[l];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res;
        res = solution.intToRoman(1994);
        System.out.println(res);
    }
}
