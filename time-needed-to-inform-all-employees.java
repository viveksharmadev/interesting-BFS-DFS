// https://leetcode.com/problems/time-needed-to-inform-all-employees/
class time-needed-to-inform-all-employees {
    // tc -> n, sc-> n
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++) graph[i] = new LinkedList<>();
        for(int i=0; i<n; i++) 
            if(manager[i]!=-1)
                graph[manager[i]].add(i);
        // Since it's a tree, we don't need `visited` array
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{headID, 0});
        int res = 0;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            int currManager = top[0], mins = top[1];
            res = Math.max(res, mins);
            for(int m : graph[currManager])
                q.offer(new int[]{m, mins + informTime[currManager]});
        }
        return res;
    }
}
