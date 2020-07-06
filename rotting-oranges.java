// https://leetcode.com/problems/rotting-oranges/
class rotting-oranges{
    // tc -> m*n, sc-> m*n
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        
        int m = grid.length, n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});                    
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges==0) return 0;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int mins = 0;
        while(!q.isEmpty()){
            if(freshOranges == 0) return mins;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    if(x<0 || x>m-1 || y<0 || y>n-1 || grid[x][y]!=1)
                        continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                    freshOranges--;                    
                }
            }
            mins++;
        }
        return -1;
    }
}
