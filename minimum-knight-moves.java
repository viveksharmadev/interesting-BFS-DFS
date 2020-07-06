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
    
    // tc -> x*y, sc-> x*y
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        return getMinKnightMoves(x, y, new HashMap<String, Integer>());
    }
    
    private int getMinKnightMoves(int x, int y, Map<String, Integer> cache){        
        if(x+y == 0) return 0;
        else if(x+y == 2) return 2;
        
        String key = x + " " + y;
        
        if(cache.containsKey(key)) 
            return cache.get(key);
            
        int min = Math.min(getMinKnightMoves(Math.abs(x-1), Math.abs(y-2), cache),
                           getMinKnightMoves(Math.abs(x-2), Math.abs(y-1), cache)) + 1;
        
        cache.put(key, min);
        return cache.get(key);
    }
}
