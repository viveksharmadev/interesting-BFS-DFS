// https://leetcode.com/problems/open-the-lock/

class Solution {
    // tc -> n^2 * A^n + D(deadend)
    // Where n is 4, A is 10 numbers (0-9), D is size of deadends
    // sc -> A^n(For Queue) + D(deadends set)
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                String str = q.poll();
                
                if(deadendSet.contains(str)) continue;
                
                if(str.equals(target)) return level;
                
                StringBuilder sb = new StringBuilder(str);
                
                for(int j=0; j<4; j++){
                    char c = str.charAt(j);
                    
                    String firstStr = sb.substring(0,j) 
                              + (c=='9' ? 0 : c-'0' + 1)
                              + str.substring(j+1);
                    
                    if(!visited.contains(firstStr) 
                       && !deadendSet.contains(firstStr)){
                        visited.add(firstStr);
                        q.offer(firstStr);
                    }
                    
                    String secondStr = sb.substring(0,j)
                              + (c=='0' ? 9 : c-'0' - 1)
                              + str.substring(j+1);
                    
                    if(!visited.contains(secondStr)
                      && !deadendSet.contains(secondStr)){
                        visited.add(secondStr);
                        q.offer(secondStr);
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}
