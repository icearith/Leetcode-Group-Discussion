class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // up
                    if (i - 1 < 0 || grid[i - 1][j] == 0)
                        perimeter++;
                    // buttom
                    if (i + 1 >= grid.length || grid[i + 1][j] == 0)
                        perimeter++;
                    // left
                    if (j - 1 < 0 || grid[i][j - 1] == 0)
                        perimeter++;
                    // right
                    if (j + 1 >= grid[0].length || grid[i][j + 1] == 0)
                        perimeter++;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int res = new Solution().islandPerimeter(new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0},
        });
        System.out.println(res);
    }
}
