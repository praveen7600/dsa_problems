class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        return helper(arr,target,0,n-1);
    }
    public int helper(int[]arr,int target,int sum,int ind){
        if(ind==0){
            if(arr[ind]+sum==target && sum-arr[ind]==target){
                return 2;
            }
            if(arr[ind]+sum==target || sum-arr[ind]==target){
                return 1;
            }
            return 0;
        }
        int left=helper(arr,target,sum+arr[ind],ind-1);
        int right=helper(arr,target,sum-arr[ind],ind-1);
        return left+right;
    }
}