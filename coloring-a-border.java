// https://leetcode.com/problems/coloring-a-border/
class Solution {
    // tc -> rows*cols, sc-> rows*cols
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid==null || grid.length==0)
            return grid;
        
        if(grid[r0][c0]==color) return grid;
        
        int oldColor = grid[r0][c0];
        fillGrid(grid, r0, c0, oldColor, color);
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        
        return grid;
    }
    
    private void fillGrid(int[][] grid, int row, int col, int oldColor, 
                          int newColor){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1
          || grid[row][col]!=oldColor)
            return;
        
        grid[row][col] = -oldColor;     
        
        fillGrid(grid, row+1, col, oldColor, newColor);
        fillGrid(grid, row-1, col, oldColor, newColor);
        fillGrid(grid, row, col+1, oldColor, newColor);
        fillGrid(grid, row, col-1, oldColor, newColor);
        
        if(row>0 && row<grid.length-1 && col>0 && col<grid[0].length-1
          && oldColor == Math.abs(grid[row+1][col])
          && oldColor == Math.abs(grid[row][col+1])
          && oldColor == Math.abs(grid[row-1][col])
          && oldColor == Math.abs(grid[row][col-1]))
              grid[row][col] = oldColor;      
    }
}
