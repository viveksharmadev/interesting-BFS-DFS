// https://leetcode.com/problems/word-break/
class Solution {
   // tc -> n^2, sc-> n
   public boolean wordBreak(String s, List<String> wordDict) {
      return dfs(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]); 
   }
   
   private boolean dfs(String s, Set<String> wordDict, int index, Boolean[] visited){
       if(index==s.length())
           return true;
       if(visited[index]!=null) {
           return visited[index];
       }
       for(int i=index+1; i<=s.length(); i++){
           if(wordDict.contains(s.substring(index,i)) 
              && dfs(s, wordDict, i, visited)){
               return true;
           }            
       }
       visited[index] = false;
       return false;
   }
}

// BFS
class Solution {
   // tc -> n^2, sc-> n
   public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> wordDictSet = new HashSet(wordDict);
       Queue<Integer> q = new LinkedList<>();
       q.offer(0);
       int[] visited = new int[s.length()];        
       while(!q.isEmpty()){
           int start = q.poll();
           if(visited[start]==1) continue;
           for(int end = start+1; end<=s.length(); end++){
               if(wordDictSet.contains(s.substring(start, end))){
                   q.offer(end);
                   if(end==s.length()) return true;
               }
           }
           visited[start] = 1;
       }
       return false;
   }
}

// May be more intutive BFS

class Solution {
    // tc -> n^2, sc-> n
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        int[] visited = new int[s.length()];
        visited[0] = 1;
        
        Set<String> wordSet = new HashSet<>(wordDict);
        
        while(!q.isEmpty()){
            int currIndex = q.poll();
            
            for(int end = currIndex+1; end<=s.length(); end++){
                if(wordSet.contains(s.substring(currIndex, end))){
                    
                    if(end==s.length()) return true;
                    
                    if(visited[end]==1) continue;
                    
                    visited[end] = 1;
                    q.offer(end);
                }
            }
        }
        
        return false;
    }
}
