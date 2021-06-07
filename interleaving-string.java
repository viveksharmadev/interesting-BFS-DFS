// https://leetcode.com/problems/interleaving-string/
class Solution {
    // tc -> m+n, sc-> m+n
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length()) return false;
        
        return doStrsInterleave(s1, s2, s3, 0, 0, 0, s1.length(), s2.length(), s3.length(), new HashMap<>());
    }
    
    private boolean doStrsInterleave(String s1, 
                                    String s2, 
                                    String s3,
                                    int i,
                                    int j,
                                    int k,
                                    int len1,
                                    int len2,
                                    int len3,
                                    Map<String, Boolean> cache){
        
        if(k == len3)
            return i==len1 && j==len2 ? true : false;        
        
        String key = i + "-" + j + "-" + k;
        
        if(cache.containsKey(key)) return cache.get(key);
       
        boolean option1 = false, option2 = false;      
        
        if(i==s1.length()){
            option1 = s2.charAt(j) == s3.charAt(k) 
                ? doStrsInterleave(s1, s2, s3, i, j+1, k+1, len1, len2, len3, cache)
                : false;
            
            cache.put(key, option1);
            
            return option1;
        }
        
        if(j==s2.length()){
            option2 = s1.charAt(i) == s3.charAt(k)
                ? doStrsInterleave(s1, s2, s3, i+1, j, k+1, len1, len2, len3, cache)
                : false;
            
            cache.put(key, option2);
            
            return option2;
        }
              
        if(s1.charAt(i) == s3.charAt(k))
            option1 = doStrsInterleave(s1, s2, s3, i+1, j, k+1, len1, len2, len3, cache);    
        if(s2.charAt(j) == s3.charAt(k))
            option2 = doStrsInterleave(s1, s2, s3, i, j+1, k+1, len1, len2, len3, cache);               
        cache.put(key, option1||option2);
        
        return cache.get(key);
    }
}

class Solution {
    // tc -> m+n, sc -> m+n
    public boolean isInterleave(String s1, String s2, String s3) {
    char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
    int m = s1.length(), n = s2.length();
    if(m + n != s3.length()) return false;
    return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
}

public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
    if(invalid[i][j]) return false;
    if(k == c3.length) return true;
    boolean valid = 
        i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || 
        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
    if(!valid) invalid[i][j] = true;
    return valid;
}
}
