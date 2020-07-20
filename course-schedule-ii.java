// https://leetcode.com/problems/course-schedule-ii/
class course-schedule-ii {
    // tc -> V+E, sc-> V+E
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for(int[] pre : prerequisites)
            degreeMap.put(pre[0], degreeMap.getOrDefault(pre[0],0)+1);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
            if(degreeMap.getOrDefault(i,0)==0)
                q.offer(i);
        
        int[] res = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            res[i++] = course;
            numCourses--;
            for(int[] pre : prerequisites){
                if(course==pre[1]){
                    if(degreeMap.containsKey(pre[0]))
                        if(degreeMap.get(pre[0])>0)
                            degreeMap.put(pre[0], degreeMap.get(pre[0])-1);
                    if(degreeMap.get(pre[0])==0)
                        q.offer(pre[0]);
                }
            }
        }
        
        return numCourses==0 ? res : new int[]{};
    }
}
