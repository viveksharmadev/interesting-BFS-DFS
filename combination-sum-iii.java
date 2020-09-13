// https://leetcode.com/problems/combination-sum-iii/
class Solution {
    // tc -> (9!*k)/(9-k)!, sc-> k
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        
        combinationsSum(n, k, 1, new LinkedList<>(), result);
        
        return result;
    }
    
    private void combinationsSum(int target, int k,
                                 int index,
                                 List<Integer> list, List<List<Integer>> result){
        if(target < 0) return;
        
        if(target == 0 && list.size()==k){
            result.add(new LinkedList(list));
        }
        
        for(int i=index; i<=9; i++){            
            list.add(i);
            combinationsSum(target-i, k, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}
