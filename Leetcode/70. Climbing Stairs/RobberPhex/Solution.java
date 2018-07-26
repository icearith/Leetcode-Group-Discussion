import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 1) {
            map.put(n, 1);
            return 1;
        }
        int ans = climbStairs(n - 1);
        if (n >= 2)
            ans += climbStairs(n - 2);
        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        int res;
        Solution solution = new Solution();

        res = solution.climbStairs(2);
        System.out.println(res);
        res = solution.climbStairs(44);
        System.out.println(res);
    }
}
