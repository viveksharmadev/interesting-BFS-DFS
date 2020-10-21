// https://leetcode.com/problems/alien-dictionary/
class Solution {
    // tc -> V+E, sc-> V+E
    public String alienOrder(String[] words) {
        Map<Character, Integer> degreeMap = new HashMap<>();
        
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                
                char c = word.charAt(i);
                
                degreeMap.put(c, 0);
            }
        }
        
        Map<Character, Set<Character>> wordsMap
            = new HashMap<>();
        
        for(int i=0; i<words.length-1; i++){
            String firstWord = words[i];
            String nextWord = words[i+1];
            
            // ["abc","ab"]
            if(firstWord.length() > nextWord.length()
              && firstWord.startsWith(nextWord)) return "";
            
            int minLength = Math.min(firstWord.length(), nextWord.length());
            
            for(int j=0; j<minLength; j++){
                
                char c1 = firstWord.charAt(j);
                char c2 = nextWord.charAt(j);
                
                if(c1!=c2){
                    
                    Set<Character> set 
                        = wordsMap.getOrDefault(c1, new HashSet<>());
                    
                    if(!set.contains(c2)){
                        set.add(c2);
                        
                        wordsMap.put(c1, set);
                        
                        degreeMap.put(c2, degreeMap.getOrDefault(c2, 0)+1);
                    }
                    
                    // ["za","zb","ca","cb"]
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(char key : degreeMap.keySet()){
            if(degreeMap.get(key)==0)
                q.offer(key);
        }
        
        
        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()){
            
            char curr = q.poll();
            
            result.append(curr);
            
            if(wordsMap.containsKey(curr)){
                Set<Character> set = wordsMap.get(curr);
                
                for(char c : set){
                    degreeMap.put(c, degreeMap.get(c)-1);
                    
                    if(degreeMap.get(c)==0) q.offer(c);
                }
            }
        }
        
        // ["z","z"]
        return result.length()==degreeMap.size() ? result.toString() : "";
    }
} 
