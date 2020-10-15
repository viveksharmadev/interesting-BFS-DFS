// https://leetcode.com/problems/house-robber-ii/
class Solution {
    // tc -> n, sc-> 1
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n < 2) return nums[0];
        
        int firstOption = getMaxAmount(nums, 0, n-2);
        int secondOption = getMaxAmount(nums, 1, n-1);
        
        return Math.max(firstOption, secondOption);
    }
    
    private int getMaxAmount(int[] nums, int start, int end){
        
        int evenSum = 0, oddSum = 0;
        
        for(int i=start; i<=end; i++){
            if(i%2==0)
                evenSum = Math.max(evenSum+nums[i], oddSum);
            else
                oddSum = Math.max(oddSum+nums[i], evenSum);
        }
        
        return Math.max(evenSum, oddSum);
    }
}
