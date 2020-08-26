// https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    // tc -> n(days), sc-> n(days)
    public int mincostTickets(int[] days, int[] costs) {
        return getMinCostTickets(days, costs, 0, 0, new Integer[days.length]);
    }
    
    private int getMinCostTickets(int[] days, int[] costs, int currIndex, int currDay, Integer[] cache){
        if(currIndex == days.length) return 0;
        
        if(days[currIndex] < currDay){
            return getMinCostTickets(days, costs, currIndex+1, currDay, cache);
        } else{
                // It should cache only for given days, I guess 
                if(cache[currIndex]!=null) return cache[currIndex];
                int firstOption = getMinCostTickets(days, costs, currIndex+1, 
                                                    days[currIndex]+1, cache) + costs[0];
                int secondOption = getMinCostTickets(days, costs, currIndex+1, 
                                                     days[currIndex]+7, cache) + costs[1];
                int thirdOption = getMinCostTickets(days, costs, currIndex+1, 
                                                    days[currIndex]+30, cache) + costs[2];
                cache[currIndex] = Math.min(firstOption, Math.min(secondOption, thirdOption));
                return cache[currIndex];
        }
    }
}
