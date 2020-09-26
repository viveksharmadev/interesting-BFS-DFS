// https://leetcode.com/problems/delete-operation-for-two-strings/
class Solution {
// tc -> m*n, sc-> m*n
    public int minDistance(String word1, String word2) {
        return getMinDistance(word1, word2, 0, 0, 
                              new int[word1.length()][word2.length()]);
    }
    
    private int getMinDistance(String word1, String word2, 
                              int i, int j, 
                              int[][] cache){        
        if(i>=word1.length()) return word2.length()-j;
        
        if(j>=word2.length()) return word1.length()-i;
            
        
        if(cache[i][j]!=0) return cache[i][j];
              
        if(word1.charAt(i)==word2.charAt(j)){
            cache[i][j] = getMinDistance(word1, word2, i+1, j+1, cache);
        }else{
            cache[i][j] = 1 + Math.min(getMinDistance(word1, word2, i+1, j, cache),
                                       getMinDistance(word1, word2, i, j+1, cache));
        }
        return cache[i][j];
    }
}

// Easier to understand
class Solution {
    // tc -> m*n, sc-> m*n
    public int minDistance(String word1, String word2) {   
        int maxLCS = getMaxLCS(word1, word2, 0, 0, 
                                new Integer[word1.length()][word2.length()]);
        return word1.length() + word2.length() - 2*maxLCS;
    }
    
    private int getMaxLCS(String word1, String word2, 
                              int i, int j, 
                              Integer[][] cache){
        if(i==word1.length() || j==word2.length())
            return 0;
        
        if(cache[i][j]!=null) return cache[i][j];
        
        int res = 0;
        if(word1.charAt(i)==word2.charAt(j)){
            res = 1 + getMaxLCS(word1, word2, 
                                             i+1, j+1, cache);
        }else{
            res = Math.max(getMaxLCS(word1, word2,
                                                 i+1, j, cache),
                                  getMaxLCS(word1, word2,
                                                i, j+1, cache));
        }
        
        cache[i][j] = res;
        
        return cache[i][j];
    }
}

// Without Recursion
class Solution {
    // tc -> m*n, sc-> m*n
    public int minDistance(String word1, String word2) {
        if(word1==null && word2==null)
            return 0;
        
        int m = word1.length(), n = word2.length();
        
        int lcs = getLCS(word1, word2, m, n, new int[m+1][n+1]);
        
        return (m+n) - (2*lcs);
    }
    
    
    private int getLCS(String word1, String word2, int m, int n, int[][] cache){
      
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1] + 1;
                }else{
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        
        return cache[m][n];
    }
    
}
