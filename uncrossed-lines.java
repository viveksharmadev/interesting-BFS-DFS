// https://leetcode.com/problems/uncrossed-lines/
class uncrossed-lines {

// Recursion with caching (Time Limit Exceeded on Leetcode)
  // tc -> m*n, sc-> m*n
   public int maxUncrossedLines(int[] A, int[] B) {
       return getMaxUncrossedLines(A, B, 0, 0, new int[A.length][B.length]);
   }
   
   private int getMaxUncrossedLines(int[] A, int[] B, int startA, int startB, int[][] cache){
       if(startA==A.length || startB==B.length) return 0;
       
       if(cache[startA][startB]!=0) return cache[startA][startB];
       
       int res = 0;        
       if(A[startA]==B[startB]){
           res = 1 + getMaxUncrossedLines(A, B, startA+1, startB+1, cache);
       }else{
           res = Math.max(getMaxUncrossedLines(A, B, startA+1, startB, cache), 
                          getMaxUncrossedLines(A, B, startA, startB+1, cache));
       }
       cache[startA][startB] = res;
       return cache[startA][startB];
   }
   
    // tc -> m*n, sc-> m*n
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] cache = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(A[i-1]==B[j-1]){
                    cache[i][j] = 1 + cache[i-1][j-1];
                }else{
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return cache[m][n];
    }
}
