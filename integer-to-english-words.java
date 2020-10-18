// https://leetcode.com/problems/integer-to-english-words/
class Solution {
    // tc -> n, sc-> n
    private static final String[] BELOW_TWENTY 
        = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
          "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
          "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private static final String[] TENS 
        = {"", "Ten", "Twenty", "Thirty","Forty",
           "Fifty", "Sixty", "Seventy",
           "Eighty", "Ninety"};
    
    private static final String[] THOUSANDS
        = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        String result = "";
        
        int i=0;
        
        while(num > 0){     
            if(num%1000!=0)
            result = getStrBelowThousand(num%1000) 
                + THOUSANDS[i] + " " +  result;
            
            num /= 1000;
            
            i++;
        }
        
        return result.trim();
    }
    
    private String getStrBelowThousand(int num){       
        if(num == 0){
            return "";
        }else if(num < 20){
            return BELOW_TWENTY[num] + " ";
        }else if(num < 100){
            return TENS[num/10] + " " + getStrBelowThousand(num%10);
        }else{
            return BELOW_TWENTY[num/100] 
                + " Hundred " + getStrBelowThousand(num%100);
        }
    }
}
