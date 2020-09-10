// https://leetcode.com/problems/decode-ways/

class Solution {
    // tc -> 2^n, sc-> n
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        
        return getDecodeWays(s, 0);
    }
    
    private int getDecodeWays(String s, int index){
        if(index == s.length()) return 1;
        
        if(s.charAt(index)=='0') return 0;
            
        int result = getDecodeWays(s, index+1);
        
        if(index < s.length()-1 
           && (s.charAt(index)=='1' || (s.charAt(index)=='2' 
                                    && s.charAt(index+1)<='6')))
            result += getDecodeWays(s, index+2);
        
        return result;
    }
}

class Solution {
    // tc -> n, sc-> n
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        
        return getDecodeWays(s, 0, new Integer[s.length()]);
    }
    
    private int getDecodeWays(String s, int index, Integer[] cache){
        if(index == s.length()) return 1;
        
        if(s.charAt(index)=='0') return 0;
        
        if(cache[index]!=null) return cache[index];
        
        int result = getDecodeWays(s, index+1, cache);
        
        if(index < s.length()-1 
           && (s.charAt(index)=='1' || (s.charAt(index)=='2' 
                                    && s.charAt(index+1)<='6')))
            result += getDecodeWays(s, index+2, cache);
        
        cache[index] = result;
        
        return cache[index];
    }
}
