// https://leetcode.com/problems/surrounded-regions/

class surrounded-regions {
    /*
    Modify the dfs used in Number of Island.
Using DFS to traverse the boundaries, when 'O' is found, 
fire the dfs() to flip all the connected 'O' with 
boundary 'O' ones, into ' * '.After that, go through 
the board and flip the other 'O' to 'X', since these 'O' 
cannot escape the board. Then flip all the '*' to 'O', 
indicating these 'O' were changed by dfs() to '*' earlier 
to mark them connected with boundaries.
    */
    // tc -> m*n, sc-> m*n
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int m = board.length;
        int n = board[0].length;
        
        // Check the first and last col
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                dfs(i, 1, board);
            }
            if(board[i][n-1]=='O'){
                dfs(i, n-2, board);
            }
        }
        
        // Check the first and last row
        for(int i=0; i<n; i++){
            if(board[0][i]=='O'){
                dfs(1, i, board);
            }
            if(board[m-1][i]=='O'){
                dfs(m-2,i, board);
            }
        }
        
        // Flip O to X that dfs did not take care because they are not connected
        // Flip * to O 
        // Skip the boundaries
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='*'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(int row, int col, char[][] board){
        if(row<=0 || row>=board.length-1 || col<=0 || col>=board[0].length-1
          || board[row][col]=='X' || board[row][col]=='*')
            return;
        if(board[row][col]=='O')
            board[row][col] = '*';
        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}
