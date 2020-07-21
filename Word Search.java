class Solution {
    int[][] t = null;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        
        int row = board.length, col = board[0].length, index = 0;        
        t = new int[row][col];   
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(checkWord(word, 0, i, j, board))
                    return true;
            }
        }
      return false;  
    }
    
    public boolean checkWord(String word, int index, int row, int col, char[][] board) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if(board[row][col] == word.charAt(index) && t[row][col] == 0) {
            if(index == word.length() - 1)
                return true;
            t[row][col] = 1;
            if(checkWord(word, index + 1, row - 1, col, board) ||
                    checkWord(word, index + 1, row + 1, col, board) ||
                    checkWord(word, index + 1, row, col - 1, board) ||
                    checkWord(word, index + 1, row, col + 1, board)) {
                        return true;
                    } else {
                       t[row][col] = 0;
                    }
        }
        return false; 
    }
}