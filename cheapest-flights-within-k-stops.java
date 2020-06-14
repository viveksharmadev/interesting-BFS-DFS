// https://leetcode.com/problems/cheapest-flights-within-k-stops/
class cheapest-flights-within-k-stops {
    // tc -> V^2*logV, sc-> V^2
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> flightsMap = new HashMap<>();
        for(int[] f : flights){
            flightsMap.putIfAbsent(f[0], new HashMap<>());
            flightsMap.get(f[0]).put(f[1], f[2]); // source, destination, price
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0, src, K+1}); // {price, source city, stops(K)}
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city==dst) return price;
            if(stops > 0){
                Map<Integer, Integer> map = flightsMap.getOrDefault(city, new HashMap<>());
                for(int key : map.keySet()){
                    pq.offer(new int[]{price+map.get(key), key, stops-1});                        
                }
            }
        }
        return -1;
    }
}
