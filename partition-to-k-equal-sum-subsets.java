// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
// Same as https://leetcode.com/problems/matchsticks-to-square/
/* naively we will make O(k!) calls to search, 
       then an additional O(k^(N-k)) 
       calls after every element of groups is nonzero.
       tc-> k!*k^(n-k), sc-> n
    */
class partition-to-k-equal-sum-subsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return false;
        }
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(k<=0 || sum%k!=0){
            return false;
        }
        
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, k, 0, 0, sum/k);
    }
    
    private boolean helper(int[] nums, boolean[] visited, int k, int startIndex, int currSum, int target){
        if(currSum > target){
            return false;
        }
        if(k==1){
            return true;
        }
        
        if(currSum == target){
            return helper(nums, visited, k-1, 0, 0, target);
        }
        
        for(int i=startIndex; i<nums.length; i++){
            if(!visited[i]){
                visited[i]=true;
            if(helper(nums, visited, k, i+1, currSum+nums[i], target)){
                return true;
            }
                visited[i]=false;
        }
    }
        return false;
}
}
