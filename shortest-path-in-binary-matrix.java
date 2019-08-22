// https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    // tc -> m*n, sc-> m*n
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1; 
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                if(curr[0]==m-1 && curr[1]==n-1) return level;
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && grid[x][y]==0){
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
}
