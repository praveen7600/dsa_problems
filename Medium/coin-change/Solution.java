class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int mincoin= helper(coins,n-1,amount,dp);
        return mincoin==1e9?-1:mincoin;
        
    }
    public int helper(int[] coins,int ind,int target,int[][] dp){

        if(ind==0){
            if(target%coins[ind]==0){
                return target/coins[ind];
            }
            return (int)1e9;
        }

        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }

        int nottake=0+helper(coins,ind-1,target,dp);
        int take=Integer.MAX_VALUE;
        if(coins[ind]<=target){
            take=1+helper(coins,ind,target-coins[ind],dp);
        }
        return dp[ind][target]=Math.min(take,nottake);
    }
}