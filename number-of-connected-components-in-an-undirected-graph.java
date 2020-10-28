// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
/*Consider this as we have to connect the graph using Union Find, and need to decrease when the parents are different 
in this way we will exactly get the connected components*/
class Solution {
   // tc -> ElogV, sc-> V
   public int countComponents(int n, int[][] edges) {
       int[] sets = new int[n];
       for(int i=0; i<n; i++)
           sets[i] = i;
       
       for(int[] edge : edges){
           int u = find(edge[0], sets);
           int v = find(edge[1], sets);
           if(u!=v)
               n--;
           sets[u] = v;            
       }
       return n;
   }
   
   private int find(int v, int[] sets){
       return sets[v]==v ? v : find(sets[sets[v]], sets);
   }
}

// DFS
class Solution {
    // tc -> V+E, sc-> V+E
    public int countComponents(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new LinkedList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                visitComponents(i, graph, visited);
                count++;
            }            
        }
        
        return count;
    }
    
    private void visitComponents(int i, Map<Integer, List<Integer>> graph,
                                Set<Integer> visited){
        if(visited.contains(i)) return;
        
        visited.add(i);
        
        List<Integer> list = graph.get(i);
        
        for(int curr : list){
            visitComponents(curr, graph, visited);
        }
    }
}
