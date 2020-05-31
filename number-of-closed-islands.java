// https://leetcode.com/problems/number-of-closed-islands/

class number-of-closed-islands {
    // tc -> m*n, sc-> m*n
    public int closedIsland(int[][] grid) {
        int res = 0;
        if(grid==null || grid.length==0) return res;
        
        int m = grid.length, n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    if(i==0 || j==0 || i==m-1 || j==n-1)
                        fillGrid(grid, i, j);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    fillGrid(grid, i, j);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void fillGrid(int[][] grid, int row, int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1
         || grid[row][col]!=0)
            return;
        grid[row][col] = 1;
        fillGrid(grid, row+1, col);
        fillGrid(grid, row-1, col);
        fillGrid(grid, row, col+1);
        fillGrid(grid, row, col-1);
    }
}
