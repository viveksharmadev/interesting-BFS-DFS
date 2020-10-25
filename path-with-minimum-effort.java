// https://leetcode.com/problems/path-with-minimum-effort/
class Solution {
    // tc -> m*n*logm*n, sc-> m*n
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2]-b[2]));
        pq.offer(new int[]{0, 0, 0});
    
        final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int[][] dist = new int[m][n];
        
        for(int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        while(!pq.isEmpty()){
            int size = pq.size();
            
            for(int i=0; i<size; i++){
                int[] curr = pq.poll();
                int currX = curr[0];
                int currY = curr[1];
                int currVal  = curr[2];
                                                   
                if(currX==m-1 && currY==n-1) return currVal;
                
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    
                    if(x<0 || x>m-1 || y<0 || y>n-1) continue;
                    
                    int currMax = Math.max(currVal, 
                                           Math.abs(heights[x][y] 
                                                    - heights[currX][currY]));
                    
                    if(currMax < dist[x][y]){
                        dist[x][y] = currMax;
                        pq.offer(new int[]{x, y, dist[x][y]});
                    }
                }
                
            }
        }
        
        return -1; 
    }
}
