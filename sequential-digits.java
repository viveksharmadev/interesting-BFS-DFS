// https://leetcode.com/problems/sequential-digits/

class Solution {
    // tc -> 1, sc-> 1 because there would be only 1-9 digits
    public List<Integer> sequentialDigits(int low, int high) {
        // Result
        List<Integer> result = new LinkedList<>();
        
        // Queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=9; i++){
            q.offer(i);
        }
        
        while(!q.isEmpty()){
            // Poll from Queue
            int curr = q.poll();
            
            // Return result if curr exceeded high
            if(curr > high) 
                return result;
            
            // Add to Result
            if(curr>=low && curr<=high){
                result.add(curr);
            }
            
            // Mod
            int mod = curr%10;
            
            // next number
            int next = 0;
            
            /* Check if mod is less than 9 to set next number 
               and offer to Queue*/
            if(mod < 9){
                // Set next number
                next = curr*10 + (mod+1);                
                // Offer next number to queue
                q.offer(next);
            }
            
        }
        
        // Return result
        return result;
    }
}
