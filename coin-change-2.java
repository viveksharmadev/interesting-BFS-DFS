// https://leetcode.com/problems/coin-change-2/
class coin-change-2 {
    // tc -> S(amount)*n(coins length), sc-> S(amount)*n(coins length)
    public int change(int amount, int[] coins) {
        return getCoinsChange(amount, coins, new Integer[coins.length+1][amount+1], 0);
    }
    
    private int getCoinsChange(int amount, int[] coins, Integer[][] count, int index){
        // we need to get the below line above than amount<0 condition to handle amount 0 and empty coins array
        if(amount==0) return 1; 
        if(amount < 0 || index==coins.length) return 0;        
        if(count[index][amount]!=null) return count[index][amount];
        int sum1 = getCoinsChange(amount-coins[index], coins, count, index);
        int sum2 = getCoinsChange(amount, coins, count, index+1);
        count[index][amount] = sum1 + sum2;
        return count[index][amount];
    }
}
