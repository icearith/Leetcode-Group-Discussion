import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    private Map<Integer, HashSet<Integer>> obstacleMap = new HashMap<>();

    public int robotSim(int[] commands, int[][] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            HashSet<Integer> ySet = obstacleMap.get(obstacles[i][0]);
            if (ySet != null) {
                ySet.add(obstacles[i][1]);
            } else {
                ySet = new HashSet<>();
                ySet.add(obstacles[i][1]);
                obstacleMap.put(obstacles[i][0], ySet);
            }
        }

        int ans = Integer.MIN_VALUE;
        int[] loc = new int[2];
        int direction = 0;
        int[][] directionMap = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };
        for (int comm : commands) {
            switch (comm) {
                case -2:
                    direction = (direction + 4 - 1) % 4;
                    break;
                case -1:
                    direction = (direction + 1) % 4;
                    break;
                default:
                    int[] v = directionMap[direction];
                    int cnt = 0;
                    while (cnt < comm && (
                            !obstacleMap.containsKey(loc[0] + v[0]) ||
                                    !obstacleMap.get(loc[0] + v[0]).contains(loc[1] + v[1])
                    )) {
                        loc[0] += v[0];
                        loc[1] += v[1];
                        cnt++;
                    }
                    ans = Math.max(ans, loc[0] * loc[0] + loc[1] * loc[1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().robotSim(new int[]{4, -1, 3}, new int[][]{});
        System.out.println(res);
        res = new Solution().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{new int[]{2, 4}});
        System.out.println(res);
    }
}
