// https://leetcode.com/problems/possible-bipartition/
class possible-bipartition {
    // tc -> V+E, sc-> V+E
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] dislike : dislikes){
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        
        int[] colors = new int[N+1];        
        for(int i=1; i<=N; i++){
            if(colors[i]!=0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next : graph.get(curr)){
                    if(colors[next]==0){
                        colors[next] = -colors[curr];
                        q.offer(next);
                    }else if(colors[next] != -colors[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
