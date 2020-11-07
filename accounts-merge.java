// https://leetcode.com/problems/accounts-merge/
class Solution {
    // I think below for complexities
    // tc -> m*(nlogn) where m is accounts size, n is accounts[i] size
    // sc -> m*n where m is accounts size, n is accounts[i] size
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new LinkedList<>();
        
        if(accounts==null || accounts.size()==0)
            return result;
        
        Map<String, Set<String>> emailsGraph = new HashMap<>();
        Map<String, String> emailsToNames = new HashMap<>();
        
        //Build Graph
        for(List<String> account : accounts){
            String userName = account.get(0);
            
            for(int i=1; i<account.size(); i++){
                String currEmail = account.get(i);
                
                emailsGraph.putIfAbsent(currEmail, new HashSet<>());
                emailsToNames.put(currEmail, userName);
                
                if(i==1) continue; // just stitching emails not name
                
                String prevEmail = account.get(i-1);
                
                emailsGraph.get(currEmail).add(prevEmail);
                emailsGraph.get(prevEmail).add(currEmail);
            }
        }
        
        Set<String> visited = new HashSet<>();
        
        for(String email : emailsToNames.keySet()){
            List<String> list = new ArrayList<>();
            
            if(visited.contains(email)) continue;
            
            visited.add(email);
            
            buildEmailsList(emailsGraph, email, visited, list);
            
            Collections.sort(list);
            
            // Adding Name to front
            list.add(0, emailsToNames.get(email)); 
            
            result.add(list);
        }
        
        return result;
    }
    
    private void buildEmailsList(Map<String, Set<String>> emailsGraph,
                                String email, Set<String> visited,
                                List<String> list){
        list.add(email);
        
        Set<String> emailsSet = emailsGraph.get(email);
        
        for(String currEmail : emailsSet){
            if(visited.contains(currEmail)) continue;
            
            visited.add(currEmail);
            
            buildEmailsList(emailsGraph, currEmail, visited, list);
        }
    }
}
