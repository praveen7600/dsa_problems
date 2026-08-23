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
        
        int[][] dp=new int[n][sum+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return helper(arr,sum,n-1,dp);
    }
    static boolean helper(int arr[],int sum,int ind,int[][] dp){
        if(sum==0){
            return true;
        }
        if(ind==0){
            return arr[ind]==sum;
        }
        if(dp[ind][sum]!=-1){
            return dp[ind][sum]==1;
        }
        boolean pick=false;
        if(arr[ind]<=sum){
            pick=helper(arr,sum-arr[ind],ind-1,dp);
        }
        boolean notpick=helper(arr,sum,ind-1,dp);
        dp[ind][sum]= (pick||notpick)?1:0;
        return pick || notpick;
    }
}