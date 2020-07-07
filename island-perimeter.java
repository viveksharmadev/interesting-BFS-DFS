// https://leetcode.com/problems/island-perimeter/
class Solution {
    // tc -> m*n, sc-> m*n
    int res;
    public int islandPerimeter(int[][] grid) {
        res = 0;
        if(grid==null || grid.length==0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    countPerimeter(grid, i, j, new boolean[m][n]);
                    return res;
                }
            }
        }        
        return 0;
    }
    
    private void countPerimeter(int[][] grid, int row, int col,
                               boolean[][] visited){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1
          || grid[row][col]==0){
            res++;
            return;
        }
        
        if(visited[row][col]) return;
        
        visited[row][col] = true;
        
        countPerimeter(grid, row+1, col, visited);
        countPerimeter(grid, row-1, col, visited);
        countPerimeter(grid, row, col+1, visited);
        countPerimeter(grid, row, col-1, visited);        
    }
    
    // tc -> m*n, sc-> m*n
    public int islandPerimeter(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int currX = i, currY = j;
                    for(int[] dir : dirs){
                        int x = currX + dir[0];
                        int y = currY + dir[1];
                        if(x<0 || x>m-1 || y<0 || y>n-1 || grid[x][y]==0)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
