// https://leetcode.com/problems/shortest-distance-from-all-buildings/
class Solution {
    // tc -> (m*n)^2, sc-> m*n
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        
        int buildings = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j]==1){
                    buildings++;
                    markDistance(grid, i, j, dist, reach);
                }
                
            }
        }
        
        int minDist = Integer.MAX_VALUE;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j]==0 && reach[i][j]==buildings){
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    private void markDistance(int[][] grid, int row, int col, 
                             int[][] dist, int[][] reach){
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        
        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;
        
        int level = 0;
        
        while(!q.isEmpty()){
            level++;
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    
                    if(x<0 || x>m-1 || y<0 || y>n-1 
                       || visited[x][y] || grid[x][y]!=0)
                        continue;
                    
                    dist[x][y] += level;
                    
                    reach[x][y]++;
                    
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                    
                }
            }
        }
    }
} 
