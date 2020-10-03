// https://leetcode.com/problems/regular-expression-matching/
class Solution {
    // tc -> m+n*2^(m+n), sc-> m+n*2^(m+n)
    public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length()==0;
        
        if(p.length()>1 && p.charAt(1)=='*'){
            
            if(isMatch(s, p.substring(2))){
                return true;
            }
            
            else if(s.length()>0 
                    && (s.charAt(0)==p.charAt(0) 
                        || p.charAt(0)=='.')){
                return isMatch(s.substring(1), p);
            }
            
            else{
                return false;
            }
            
        }else{
            if(s.length()>0 && (s.charAt(0)==p.charAt(0)
                               || p.charAt(0)=='.')){
                return isMatch(s.substring(1), p.substring(1));
            }
            
            else{
                return false;
            }
        }
    }
}

class Solution {
    // tc -> m*n, sc-> m*n
    public boolean isMatch(String s, String p) {
        return doesMatch(s, p, 0, 0, 
                         new Boolean[s.length()+1][p.length()+1]);
    }
    
    private boolean doesMatch(String str, String pattern,
                             int i, int j,
                             Boolean[][] cache){
        
        if(j==pattern.length())
            return i==str.length();
        
        if(cache[i][j]!=null) return cache[i][j];
             
        if(j+1<pattern.length() 
           && pattern.charAt(j+1)=='*'){
            
            if(doesMatch(str, pattern, i, j+2, cache)){
                return cache[i][j] = true;
            }
            
            else if(i < str.length() 
                   && (str.charAt(i)==pattern.charAt(j) 
                      || pattern.charAt(j)=='.')){
                
                return cache[i][j] = doesMatch(str, pattern, i+1, j, cache);
            }
            
            else{
                return cache[i][j] = false;
            }
            
        }else{
            
            if(i < str.length() 
                   && (str.charAt(i)==pattern.charAt(j) 
                      || pattern.charAt(j)=='.')){
                
                return cache[i][j] = doesMatch(str, pattern, i+1, j+1, cache);
            }
            
            else{
                return cache[i][j] = false;
            }
        }
    }
}
