class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];

        for(int T=0;T<=amount;T++){
            if(T%coins[0]==0){
                dp[0][T]=T/coins[0];
            }
            else{
                dp[0][T]=(int) 1e9;
            }
        }
        for(int ind=1;ind<n;ind++){
            for(int target=0;target<=amount;target++){
                int nottake=0+dp[ind-1][target];
                int take=Integer.MAX_VALUE;
                if(coins[ind]<=target){
                    take=1+dp[ind][target-coins[ind]];
                }
                dp[ind][target]=Math.min(take,nottake);
            }
        }
        int ans= dp[n-1][amount];
        return ans>=1e9?-1:dp[n-1][amount]; 
        
    }
    
}