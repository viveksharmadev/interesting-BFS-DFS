// https://leetcode.com/problems/course-schedule/
class course-schedule {
    // tc -> V+E, sc-> V+E
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0)
            return true;
        
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for(int[] pre : prerequisites)
            degreeMap.put(pre[0], degreeMap.getOrDefault(pre[0],0)+1);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
            if(degreeMap.getOrDefault(i,0)==0)
                q.offer(i);
        
        while(!q.isEmpty()){
            int course = q.poll();
            numCourses--;
            for(int[] pre : prerequisites){
                if(pre[1]==course){
                    if(degreeMap.containsKey(pre[0])){
                        if(degreeMap.get(pre[0])>0)
                            degreeMap.put(pre[0], degreeMap.get(pre[0])-1);
                        if(degreeMap.get(pre[0])==0)
                            q.offer(pre[0]);
                    }
                }
            }
        }
        
        return numCourses==0 ? true : false;
    }
}
