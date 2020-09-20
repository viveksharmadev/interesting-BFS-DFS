// https://leetcode.com/problems/combination-sum-iv/
class Solution {
    // tc -> n*target(I think in worst case), sc-> target
    public int combinationSum4(int[] nums, int target) {
        // Return Combinations Sum
        return getCombinationsSum(nums, target, 
                                  new HashMap<Integer, Integer>());
    }
    
    private int getCombinationsSum(int[] nums, int target, 
                                  Map<Integer, Integer> cache){
        // Return from cache if it contains result 
        if(cache.containsKey(target))
            return cache.get(target);
        
        // Base condition
        if(target < 0)
            return 0;
        
        // Return 1 to count valid combinations
        if(target == 0)
            return 1;
        // Result
        int result = 0;
        
        // Traversing array
        for(int i=0; i<nums.length; i++){
            result += getCombinationsSum(nums, target-nums[i], cache);
        }
        
        // Populate cache
        cache.put(target, result);
        
        // Return result from cache
        return cache.get(target);
    }
}

// Little faster because of Cache as an Array
class Solution {
    // tc -> n*target(I think in worst case), sc-> target
    public int combinationSum4(int[] nums, int target) {
        // Return Combinations Sum
        return getCombinationsSum(nums, target, 
                                  new Integer[target+1]);
    }
    
    private int getCombinationsSum(int[] nums, int target, 
                                  Integer[] cache){
        // Base condition
        if(target < 0)
            return 0;
        
        // Return from cache if it contains result 
        if(cache[target] != null)
            return cache[target];
        
        // Return 1 to count valid combinations
        if(target == 0)
            return 1;
        
        // Result
        int result = 0;
        
        // Traversing array
        for(int i=0; i<nums.length; i++){
            result += getCombinationsSum(nums, target-nums[i], cache);
        }
        
        // Populate cache
        cache[target] = result;
        
        // Return result from cache
        return cache[target];
    }
}
