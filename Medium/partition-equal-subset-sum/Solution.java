class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        sum/=2;
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean pick=false;
                if(arr[i]<=target){
                    pick=dp[i-1][target-arr[i]];
                }
                boolean notpick=dp[i-1][target];
                dp[i][target]=pick || notpick;
            }
        }
        return dp[n-1][sum];
    }
    
}