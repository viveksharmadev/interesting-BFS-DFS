// https://leetcode.com/problems/number-of-enclaves/
// Similar as https://leetcode.com/problems/surrounded-regions/
class number-of-enclaves {
    // tc -> m*n, sc-> m*n
    public int numEnclaves(int[][] A) {
        int res = 0;
        if(A==null || A.length==0) return res;
        int m = A.length, n = A[0].length;
        
        // Check first col and last col
        for(int i=0; i<m; i++){
            if(A[i][0]==1){
                dfs(i,1,A);
            }
            if(A[i][n-1]==1){
                dfs(i,n-2,A);
            }
        }
        
        // check first row and last row
        for(int i=0; i<n; i++){
            if(A[0][i]==1){
                dfs(1,i, A);
            }
            if(A[m-1][i]==1){
                dfs(m-2,i,A);
            }
        }
        
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(A[i][j]==1){
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int row, int col, int[][] A){
        if(row<=0 || row>=A.length-1 || col<=0 || col>=A[0].length-1
          || A[row][col]!=1)
            return;
        A[row][col] = 0;
        dfs(row+1, col, A);
        dfs(row-1, col, A);
        dfs(row, col+1, A);
        dfs(row, col-1, A);
    }
    
    // Simpler
    // tc -> m*n, sc-> m*n
    public int numEnclaves(int[][] A) {
        int res = 0;
        if(A==null || A.length==0) return res;
        
        int m = A.length, n = A[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(A[i][j]==1){
                    if(i==0 || j==0 || i==m-1 || j==n-1){
                        dfs(A, i, j);
                    }
                }   
            }            
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(A[i][j]==1){
                    res++;
                }
            }            
        }
        
        return res;
    }
    
    private void dfs(int[][] A, int row, int col){
        if(row<0 || row>A.length-1 || col<0 || col>A[0].length-1 
           || A[row][col]!=1)
            return;
        A[row][col] = 0;
        dfs(A, row+1, col);
        dfs(A, row-1, col);
        dfs(A, row, col+1);
        dfs(A, row, col-1);
    }
}
