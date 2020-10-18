// https://leetcode.com/problems/sudoku-solver/
class Solution {
    // tc -> 9^m, sc-> m where m is number of empty cells
    public void solveSudoku(char[][] board) {        
        solveSudokuHelper(board);            
    }
    
    private boolean solveSudokuHelper(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    
                    for(char k = '1'; k<='9'; k++){
                        
                        if(isValidSudoku(board, i, j, k)){
                            board[i][j] = k;                            
                        
                        
                            if(solveSudokuHelper(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int row, int col, char val){
        
        for(int i=0; i<9; i++){
            if(board[row][i]==val) return false;
            
            else if(board[i][col]==val) return false;
            
            else if(board[3*(row/3) + i/3][3*(col/3) + i%3]==val) return false;
        }
        
        return true;
    }
}
