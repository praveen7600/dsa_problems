class Solution {
    int MOD=(int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(n,target,k,dp);
    }

    public int helper(int n,int target,int k,int dp[][]){
        if(n==0){
             return target==0?1:0;
        }
        if(target<0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int res=0;
        for(int i=1;i<=k;i++){
            res=(res+helper(n-1,target-i,k,dp))%MOD;
        }

        return dp[n][target]=res;
    }
}