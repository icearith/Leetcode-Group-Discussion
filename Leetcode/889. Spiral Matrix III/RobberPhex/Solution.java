import java.util.ArrayList;

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r, int c) {
        int cnt = 1;
        int direction = 0;
        int step = 1;
        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{r, c});
        while (cnt < R * C) {
            switch (direction) {
                case 0:
                    for (int i = 0; i < step; i++) {
                        c += 1;
                        if (0 <= r && r < R && 0 <= c && c < C) {
                            cnt++;
                            res.add(new int[]{r, c});
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < step; i++) {
                        r += 1;
                        if (0 <= r && r < R && 0 <= c && c < C) {
                            cnt++;
                            res.add(new int[]{r, c});
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < step; i++) {
                        c -= 1;
                        if (0 <= r && r < R && 0 <= c && c < C) {
                            cnt++;
                            res.add(new int[]{r, c});
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < step; i++) {
                        r -= 1;
                        if (0 <= r && r < R && 0 <= c && c < C) {
                            cnt++;
                            res.add(new int[]{r, c});
                        }
                    }
                    break;
            }
            direction = (direction + 1) % 4;
            if (direction % 2 == 0)
                step += 1;
        }
        int[][] rres = new int[res.size()][];
        int index = 0;
        for (int[] point : res)
            rres[index++] = point;
        return rres;
    }

    public static void main(String[] args) {
        int[][] res = new Solution().spiralMatrixIII(5, 6, 1, 4);
        for (int[] point : res)
            System.out.println(point[0] + ",\t" + point[1]);
    }
}
