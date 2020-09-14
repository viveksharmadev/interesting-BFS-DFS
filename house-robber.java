// https://leetcode.com/problems/house-robber/
class Solution {
    // tc -> n, sc-> n
    public int rob(int[] nums) {
        return getMaxAmount(nums, 0, new Integer[nums.length]);
    }
    
    private int getMaxAmount(int[] nums, int start, Integer[] cache){
        if(start > nums.length-1) return 0;
        
        if(cache[start]!=null) return cache[start];
        
        int firstOption = getMaxAmount(nums, start+1, cache);
        int secondOption = getMaxAmount(nums, start+2, cache) + nums[start];
        
        cache[start] = Math.max(firstOption, secondOption);
        
        return cache[start];
    }
}

class Solution {
    public int rob(int[] nums) {
        // tc -> n, sc-> 1
        int oddSum = 0, evenSum = 0, sum = 0;
        
        for(int i=0; i<nums.length; i++){
            
            if(i%2==0){
                evenSum = Math.max(nums[i]+evenSum, oddSum);
            }else{
                oddSum = Math.max(nums[i]+oddSum, evenSum);
            }            

        }
        
        return Math.max(evenSum, oddSum);
    }
}
