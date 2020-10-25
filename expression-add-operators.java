// https://leetcode.com/problems/expression-add-operators/
class Solution {
    // tc -> n*4^n, sc-> n
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        
        if(num==null || num.length()==0) return result;
        
        addGivenOperators(num, target, "", result, 0, 0, 0);
        
        return result;
    }
    
    private void addGivenOperators(String num, int target, String str,
                                  List<String> result, int index,
                                  long prev, long multi){
        if(index==num.length()){
            if(prev == target)
                result.add(str);
            
            return;
        }
        
        
        for(int i=index; i<num.length(); i++){
            
            if(num.charAt(index)=='0' && i!=index){
                break;
            }
            
            Long currVal = Long.parseLong(num.substring(index, i+1));
            
            if(index==0){
                addGivenOperators(num, target, str+currVal, 
                                  result, i+1, currVal, currVal);
            }
            
            else{
                addGivenOperators(num, target, str+'+'+currVal,
                                 result, i+1, prev+currVal, currVal);
                
                addGivenOperators(num, target, str+'-'+currVal,
                                 result, i+1, prev-currVal, -currVal);
                
                addGivenOperators(num, target, str+'*'+currVal,
                                  result, i+1, 
                                  prev-multi+multi*currVal, 
                                  multi*currVal);
                
            }
            
        }
        
    }
}


// Better performance using StringBuilder
class Solution {
    // tc -> n*4^n, sc-> n
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        
        if(num==null || num.length()==0) return result;
        
        addAllOperators(num, target, new StringBuilder(), result, 0, 0, 0);
        
        return result;
    }
    
    private void addAllOperators(String num, 
                              int target,                               
                              StringBuilder sb, 
                              List<String> result,
                              int index,
                              long prev,
                              long mult){
        
        if(index==num.length()){
            if(target==prev)
                result.add(sb.toString());
                return;
        }

        for(int i=index; i<num.length(); i++){
            // We don't want to add leading 0 
            // However need to consider single digit 0
            if(num.charAt(index)=='0' && i!=index){
                break;
            }
            
            Long curr = Long.parseLong(num.substring(index, i+1));
            
            int len = sb.length();
            
            // There is no operand at very first index
            if(index == 0){
                sb.append(curr);
                addAllOperators(num, target, sb, result, i+1, curr, curr);   
                sb.setLength(len);
            }
            
            else{
                
                sb.append('+').append(curr);
                addAllOperators(num, target, sb, result, i+1, prev+curr, curr);
                sb.setLength(len);
                
                sb.append('-').append(curr);
                addAllOperators(num, target, sb, result, i+1, prev-curr, -curr);   
                sb.setLength(len);
                
                sb.append("*").append(curr);
                // need to prioitize * over other operands
                addAllOperators(num, target, sb, result, i+1, prev-mult+mult*curr, 
                                mult*curr);   
                sb.setLength(len);
                
            }
            
            }   
            
        }
}
