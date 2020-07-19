// https://leetcode.com/problems/partition-equal-subset-sum/
class partition-equal-subset-sum {
    // tc -> 2^n, sc-> n
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum%2!=0) return false;        
        
        return doesPartition(nums, sum/2, 0); 
    }
    
    private boolean doesPartition(int[] nums, int sum, int index){
        if(sum==0) return true;
        
        if(index>nums.length-1) return false;
        
        if(nums[index] <= sum)
            if(doesPartition(nums, sum-nums[index], index+1))
                return true;        
        
        return doesPartition(nums, sum, index+1);
    }    
    
     // tc -> n(nums)*s(sum), sc-> n*s
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum%2!=0) return false;        
        
        return doesPartition(nums, sum/2, 0, new Boolean[nums.length][sum]); 
    }
    
    private boolean doesPartition(int[] nums, int sum, int index,
                                 Boolean[][] cache){
        if(sum==0) return true;
        
        if(index>nums.length-1) return false;
        
        if(cache[index][sum]!=null)
            return cache[index][sum];
            
        if(nums[index] <= sum){
            if(doesPartition(nums, sum-nums[index], index+1, cache)){
                cache[index][sum] = true;
                return true;        
            }
        }
        
        cache[index][sum] =  doesPartition(nums, sum, index+1, cache);
        return cache[index][sum];
    }
}
