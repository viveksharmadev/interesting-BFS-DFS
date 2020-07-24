// https://leetcode.com/problems/all-paths-from-source-to-target/
class all-paths-from-source-to-target {
    // tc -> n*2^n, sc-> n*2^n
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        setAllPaths(graph, 0, list, res);
        
        return res;
    }
    
    private void setAllPaths(int[][] graph, int index, List<Integer> list,
                            List<List<Integer>> res){
        if(index==graph.length-1){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int next : graph[index]){
            list.add(next);
            setAllPaths(graph, next, list, res);
            list.remove(list.size()-1);
        }
    }
}
