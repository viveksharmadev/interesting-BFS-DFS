// https://leetcode.com/problems/shortest-path-visiting-all-nodes/
class Solution {
    // tc -> n*2^n, sc-> n*2^n
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1<<n) - 1;
        
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        for(int i=0; i<n; i++){
            int mask = 1<<i;
            q.offer(new int[]{i, mask});
            visited.add(i + " " + mask);
        }
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                if(curr[1]==fullMask) return level;
                for(int next : graph[curr[0]]){
                    int mask = curr[1] | 1<<next;
                    if(visited.contains(next + " " + mask))
                        continue;
                    q.offer(new int[]{next, mask});
                    visited.add(next + " " + mask);
                }
            }
            level++;
        }
        return level;
    }
}
