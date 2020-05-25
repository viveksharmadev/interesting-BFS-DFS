// https://leetcode.com/problems/path-with-maximum-gold/
class path-with-maximum-gold {
    // tc -> 4^m*n and 1 for this one because there is a limit on size
    // sc-> m*n and and 1 for this one because there is a limit on size 
    int res, sum;
    public int getMaximumGold(int[][] grid) {
        res = 0; sum = 0;
        if(grid==null || grid.length==0) return res;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(grid, i, j, 0);
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int row, int col, int sum){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1
          || grid[row][col]==0){
            res = Math.max(res, sum);
            return;
        }
        int val = grid[row][col]; // keep it for back tracking        
        grid[row][col] = 0;
        dfs(grid, row+1, col, sum+val);
        dfs(grid, row-1, col, sum+val);
        dfs(grid, row, col+1, sum+val);
        dfs(grid, row, col-1, sum+val);
        grid[row][col] = val;
    }
}
