// https://leetcode.com/problems/perfect-squares/
class perfect-squares {
    public int numSquares(int n) {
        // tc -> n^h/2, sc-> n^h/2
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        int depth = 0;
        while(!q.isEmpty()){
        int size = q.size();
        depth++;
        for(int j=0; j<size; j++){
            int u = q.poll();
            for(int i=1; i*i<=n; i++){
                int v = i*i+u;
                if(v>n) break;
                if(v==n) return depth;
                if(!visited.contains(v)){
                    q.offer(v);
                    visited.add(v);
                }
            }
        }
    }
        return depth;
    }
}
