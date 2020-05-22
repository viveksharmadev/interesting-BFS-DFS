https://leetcode.com/problems/minimum-knight-moves/
class minimum-knight-moves {
    // tc -> x*y, sc -> x*y
    private final int[][] dirs = {{1,2},{1,-2},{2,1},{-2,1},{2,-1},{-1,-2},{-2,-1},{-1,2}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                if(currX==x && currY ==y) return res;
                
                for(int[] dir : dirs){
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    if(!visited.contains(newX+","+newY) && newX>=-1 && newY>=-1){
                        q.offer(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
