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
