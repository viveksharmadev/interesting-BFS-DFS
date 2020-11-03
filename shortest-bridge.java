// https://leetcode.com/problems/shortest-bridge/
class Solution {
    // tc -> m*n, sc-> m*n
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        
        boolean isFound = false;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<m && !isFound; i++){
            for(int j=0; j<n && !isFound; j++){
                
                if(A[i][j]==1){
                    markIslands(A, i, j, q);
                    isFound = true;
                }
            }
        }
        
        int dist = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    
                    if(x<0 || x>m-1 || y<0 || y>n-1 || A[x][y]==2)
                        continue;
                    
                    if(A[x][y]==1) return dist;
                    
                    A[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
            
            dist++;
        }
        
        return -1;
    }
    
    
    
    private void markIslands(int[][] A, int row, int col, 
                             Queue q){
        if(row<0 || row>A.length-1 || col<0 || col>A[0].length-1
          || A[row][col]!=1)
            return;
        
        q.offer(new int[]{row, col});
        
        A[row][col] = 2;
        
        for(int[] dir : dirs){
            markIslands(A, row+dir[0], col+dir[1], q);            
        }    
    }
}
