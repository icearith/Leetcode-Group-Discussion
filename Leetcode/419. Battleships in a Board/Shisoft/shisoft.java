public class Solution {
    public int countBattleships(char[][] board) {
        int heads = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.' ||
                        (i > 0 && board[i - 1][j] == 'X') ||
                        (j > 0 && board[i][j - 1] == 'X'))
                    continue;
                heads++;
            }
        }
        return heads;
    }
}