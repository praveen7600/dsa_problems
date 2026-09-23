class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum-x<0){
            return -1;
        }
        if(sum-x==0){
            return n;
        }
        int maxlen=maxSubarrayLength(nums,sum-x);
        if(maxlen==-1){
            return -1;
        }
        return n-maxlen;
    }
    public int maxSubarrayLength(int[] arr,int sum){
        int maxlen=-1;
        int left=0,right=0;
        int cursum=0, n=arr.length;
        while(right<n){
            cursum+=arr[right];
            while(cursum>sum){
                cursum-=arr[left];
                left++;
            }
            if(cursum==sum){
                maxlen=Math.max(right-left+1,maxlen);
            }
            right++;
        }
        
        return maxlen;
    }
}