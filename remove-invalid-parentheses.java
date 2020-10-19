// https://leetcode.com/problems/remove-invalid-parentheses/
class Solution {
    // tc -> n*2^n, sc-> n
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        
        if(s==null) return result;
        
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        
        Set<String> visited = new HashSet<>();
        visited.add(s);
        
        boolean found = false;
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                String currStr = q.poll();

                if(isValid(currStr)){
                    result.add(currStr);
                    found = true;
                }

                if(found) continue;

                for(int j=0; j<currStr.length(); j++){

                    if(currStr.charAt(j)!='(' && currStr.charAt(j)!=')')
                        continue;

                    String newStr = currStr.substring(0,j) 
                        + currStr.substring(j+1);

                    if(visited.contains(newStr)) continue;

                    q.offer(newStr);
                    visited.add(newStr);
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String str){
        
        int open = 0;
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(c=='(') open++;
            else if(c==')' && open-- == 0) return false;
        }
        
        return open==0;
    }
}
