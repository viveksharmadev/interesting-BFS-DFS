// https://leetcode.com/problems/as-far-from-land-as-possible/
class as-far-from-land-as-possible {
    // tc -> m*n, sc-> m*n
    public int maxDistance(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        if(q.size()==0 || q.size()==m*n) return -1;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    if(x<0 || x>m-1 || y<0 || y>n-1 || grid[x][y]==1)
                        continue;
                    q.offer(new int[]{x,y}); 
                    grid[x][y] = 1;
                }
            }
            level++;
        }
        return level-1;
    }
}
