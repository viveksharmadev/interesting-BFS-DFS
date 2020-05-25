// https://leetcode.com/problems/longest-common-subsequence/
class longest-common-subsequence {
// Recursion with caching
 // tc -> m*n, sc-> m*n
    public int longestCommonSubsequence(String text1, String text2) {
        return getMaxLCS(text1, text2,0,0, 
                         new int[text1.length()][text2.length()]);
    }
    
    private int getMaxLCS(String t1, String t2, int i1, int i2, 
                          int[][] cache){
        if(i1==t1.length() || i2==t2.length()){
            return 0;
        }
        if(cache[i1][i2]!=0) return cache[i1][i2];
        int res = 0;
        if(t1.charAt(i1)==t2.charAt(i2)){
            res = 1+getMaxLCS(t1,t2,i1+1,i2+1, cache);            
        }else{
            res = Math.max(getMaxLCS(t1,t2,i1+1,i2, cache), getMaxLCS(t1,t2,i1,i2+1, cache));
        }
        cache[i1][i2] = res;
        return res;
    }
    
    // DP
    // tc -> m*n, sc-> m*n
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null || text1.length()==0 || text2==null || text2.length()==0)
            return 0;
        int m = text1.length();
        int n = text2.length();
        
        int cache[][] = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cache[i][j] = 1 + cache[i-1][j-1];
                }else{
                    cache[i][j] = Math.max(cache[i-1][j],
                                          cache[i][j-1]);
                }
            }
        }
        return cache[m][n];
    }
}
