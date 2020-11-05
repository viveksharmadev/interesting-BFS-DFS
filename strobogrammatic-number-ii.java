// https://leetcode.com/problems/strobogrammatic-number-ii/
class Solution {
    // tc -> I think -> 5^n/2(because adding 5 times in for loop, n/2 because of n-=2 in loop), sc-> 5^n/2
    public List<String> findStrobogrammatic(int n) {
        // Empty list for even number and add middle number for odd length
        List<String> result 
            = new ArrayList<>(((n&1)==0 ? Arrays.asList("") 
                                         : Arrays.asList("0", "1", "8")));
        
        if(n < 2) return result;
        
        while(n > 1){
            List<String> next = new ArrayList<>();
            
            for(String curr : result){
                if(n>3) next.add("0" + curr + "0");
                
                next.add("1" + curr + "1");
                next.add("8" + curr + "8");
                next.add("6" + curr + "9");
                next.add("9" + curr + "6");
            }
            
            result = next;
            
            n-=2;   
        }
        
        return result;
    }
} 
