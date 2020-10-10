// https://leetcode.com/problems/nested-list-weight-sum/

class Solution {
   public int depthSum(List<NestedInteger> nestedList) {
       return getDepthSum(nestedList, 1);      
   }
   
   private int getDepthSum(List<NestedInteger> nestedList, int depth){
       int res = 0;
       for(NestedInteger i : nestedList){
           res += i.isInteger() ? i.getInteger()*depth
                                   : getDepthSum(i.getList(), depth+1);
       }
       return res;
   }
}

// Another Recursive: May be easier to understand
class Solution {
    // tc -> m*n, sc-> m
    public int depthSum(List<NestedInteger> nestedList) {
        int[] sum = new int[1];
        
        depthSum(nestedList, sum, 1);   
        
        return sum[0];
    }
    
    private void depthSum(List<NestedInteger> list, int[] sum, int depth){
        
        for(NestedInteger ni : list){
            
            if(ni.isInteger()){
                sum[0] += depth * ni.getInteger();
            }else{
                depthSum(ni.getList(), sum, depth+1);
            }
            
        }
        
    }
}
 
 //BFS:
 
class Solution {
    // tc -> m*n, sc-> m
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null || nestedList.size()==0)
            return 0;
        
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.offer(nestedList);
        
        int level = 1;
        int sum = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                List<NestedInteger> list = q.poll();
                
                for(NestedInteger ni : list){
                    if(ni.isInteger()){
                        sum += ni.getInteger() * level;       
                    }else{
                        q.offer(ni.getList());
                    }
                }
                
            }
            
            level++;
        }
        
        return sum;
    }
}
