// https://leetcode.com/problems/network-delay-time/
 /*  Time Complexity: V^2 + ElogE as potentially every edge gets added to the heap.

       Space Complexity: O(V + E)
   
       Math.max will not work in place of PriorityQueue because we need to find min, and can not use Math.min() too, because it will take min as zero then, so the best way to handle this situation is to take PriorityQueue in ascending order
       Not taking visited insider inner for loop because we might end up visiting those nodes again for other route, so the best way to keep a track of visited outside for loop
   */
class Solution {
   public int networkDelayTime(int[][] times, int N, int K) {
       Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
       
       for(int[] time : times){
           graph.putIfAbsent(time[0], new HashMap<>());
           graph.get(time[0]).put(time[1], time[2]);
       }
       
       Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
       
       pq.add(new int[]{0,K});
       
       boolean[] visited = new boolean[N+1];
       int res = 0;
       
       while(!pq.isEmpty()){
           int[] curr = pq.poll();
           int currNode = curr[1];
           int currDist = curr[0];
           if(visited[currNode]) continue;
           visited[currNode] = true;
           res = currDist;
           N--;
           if(graph.containsKey(currNode)){
               for(int next : graph.get(currNode).keySet())
               pq.add(new int[]{currDist + graph.get(currNode).get(next), next});
           }
       }
       return N==0 ? res : -1;
   }
}
