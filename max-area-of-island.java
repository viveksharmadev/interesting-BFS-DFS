// https://leetcode.com/problems/max-area-of-island/
class max-area-of-island {
    // tc -> m*n, sc-> m*n
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if(grid==null || grid.length==0) return max;
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, getArea(grid, i, j));
            }
        }
        return max;
    }
    
    private int getArea(int[][] grid, int row, int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1
          || grid[row][col]!=1)
            return 0;
        grid[row][col] = 0;
        return 1 + getArea(grid, row+1, col)
            + getArea(grid, row-1, col)
            + getArea(grid, row, col+1)
            + getArea(grid, row, col-1);
    }
}
