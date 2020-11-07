// https://leetcode.com/problems/edit-distance/
class Solution {
    // tc -> m*n, sc-> m*n
    public int minDistance(String word1, String word2) {
        
        return getMinDist(word1, word2, 0, 0, 
                          new Integer[word1.length()][word2.length()]);
    }
    
    private int getMinDist(String word1, String word2, 
                          int i, int j,
                          Integer[][] cache){
        
        if(i==word1.length())
            return word2.length()-j;
        
        else if(j==word2.length())
            return word1.length()-i;
        
        if(cache[i][j] != null) return cache[i][j];
        
        if(word1.charAt(i) == word2.charAt(j)){
           cache[i][j] 
                = getMinDist(word1, word2, i+1, j+1, cache);
        }
        
        else{
            int replace = getMinDist(word1, word2, i+1, j+1, cache);
            int delete = getMinDist(word1, word2, i+1, j, cache);
            int insert = getMinDist(word1, word2, i, j+1, cache);
            
            cache[i][j] = 1 + Math.min(insert, Math.min(replace, delete));
        }
        
        return cache[i][j];
    }
}

class Solution {
    // tc -> m*n, sc-> m*n
    public int minDistance(String word1, String word2) {
        return getMinDist(word1, word2, 
                          word1.length(), 
                          word2.length(),
                          new Integer[word1.length()+1][word2.length()+1]);
    }
    
    private int getMinDist(String word1, String word2,
                          int m, int n,
                          Integer[][] cache){
        if(m==0){
            return n;
        }
        
        else if(n==0){
            return m;
        }
        
        if(cache[m][n]!=null) return cache[m][n];
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            cache[m][n] = getMinDist(word1, word2, m-1, n-1, cache);
        }
        
        else{
            int replace = getMinDist(word1, word2, m-1, n-1, cache);
            int delete = getMinDist(word1, word2, m-1, n, cache);
            int insert = getMinDist(word1, word2, m, n-1, cache);
            
            cache[m][n] = 1 + Math.min(insert, Math.min(replace, delete));
        }
        
        
        return cache[m][n];
    }
}

class Solution {
    // tc -> m*n, sc-> m*n
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n =word2.length();
        
        int[][] cache = new int[m+1][n+1];
        
        /*
        For the base case, that is, to convert a string to an empty string, 
        the mininum number of operations (deletions) is just the length of the string. 
        So we have dp[i][0] = i and dp[0][j] = j.
        */
        
        for(int i=1; i<=m; i++){
            cache[i][0] = i;
        }
        
        for(int j=1; j<=n; j++){
            cache[0][j] = j;
        }
        
        for(int i=1; i<=m; i++){
            
            for(int j=1; j<=n; j++){
                
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1];
                }
                
                else{
                    int replace = cache[i-1][j-1];
                    int delete = cache[i-1][j];
                    int insert = cache[i][j-1];
                    
                    cache[i][j] = 1 + Math.min(Math.min(replace, delete), insert);
                }
            }
        }
        
        return cache[m][n];
    }
}
