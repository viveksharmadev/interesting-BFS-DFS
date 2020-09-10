// https://leetcode.com/problems/nested-list-weight-sum-ii/
class Solution {
   // tc -> m*n, sc-> m*n
   public int depthSumInverse(List<NestedInteger> nestedList) {
       if(nestedList==null || nestedList.size()==0) return 0;
       Queue<List<NestedInteger>> q = new LinkedList<>();
       int singleSum = 0;
       int sum = 0;
       q.offer(nestedList);
       
       while(!q.isEmpty()){
           int size = q.size();
           for(int i=0; i<size; i++){
               List<NestedInteger> list = q.poll();
               for(NestedInteger nestedInteger : list){
                   if(nestedInteger.isInteger()){
                       singleSum += nestedInteger.getInteger();
                   }else{
                       q.offer(nestedInteger.getList());
                   }
               }
           }
           sum += singleSum;
       }
       return sum;
   }
}
