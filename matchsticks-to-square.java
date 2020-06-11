// https://leetcode.com/problems/matchsticks-to-square/
// Same as https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
class matchsticks-to-square {
    // tc -> 4^n, sc-> n
    public boolean makesquare(int[] nums) {        
        if(nums==null || nums.length==0){
            return false;
        }
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%4!=0){
            return false;
        }
        
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 4, 0, 0, sum/4);
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
