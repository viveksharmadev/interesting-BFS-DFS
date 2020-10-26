// https://leetcode.com/problems/number-of-islands/
class Solution {
    // tc -> m*n, sc-> m*n
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid==null || grid.length==0) return count;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    countIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void countIsland(char[][] grid, int row, int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1
          || grid[row][col] != '1')
            return;
         grid[row][col] = 0;
         countIsland(grid, row+1, col);
         countIsland(grid, row, col+1);
         countIsland(grid, row-1, col);
         countIsland(grid, row, col-1);
    }
}
