public class Solution {
    static public void main(String[] args) {
        char[][] board = {
                { 'X', '.', '.', 'X' },
                { '.', '.', '.', 'X' },
                { '.', '.', '.', 'X' }
        };
        int res = new Solution().countBattleships(board);
        System.out.println(res);
    }

    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X')
                    continue;
                else if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                else if (j > 0 && board[i][j - 1] == 'X')
                    continue;
                else
                    cnt++;
            }
        }

        return cnt;
    }
}
