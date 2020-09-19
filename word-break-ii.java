// https://leetcode.com/problems/word-break-ii/
class Solution {
   /*
    N be the length of input String and W be the number of 
    words in Dictionary
    TC-> N^2 + 2^N + W(For using Set)
    SC-> N^2 + N*2^N + W
    */
   public List<String> wordBreak(String s, List<String> wordDict) {
       return helper(s, new HashSet<String>(wordDict), 0,
                    new HashMap<Integer, List<String>>());        
   }
   
   private List<String> helper(String s, Set<String> wordDict,
                              int start, 
                               Map<Integer, List<String>> cache){
       if(cache.containsKey(start))
           return cache.get(start);
       List<String> res = new LinkedList<>();
       if(start==s.length())
           res.add("");
       
       for(int i=start+1; i<=s.length(); i++){
           if(wordDict.contains(s.substring(start, i))){
               List<String> list = helper(s, wordDict, i, cache);
               for(String l : list){
                   res.add(s.substring(start, i)
                          + (l.equals("") ? "" : " ") + l);//+L not +1
               }
           }
       }
       cache.put(start, res);
       return res;
   }
}
