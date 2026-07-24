class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        if(total-x<0) return -1;
        int maxlen= longestSubarray(nums,total-x);
        if(maxlen==-1) return -1;
        return nums.length-maxlen;
    }
    public int longestSubarray(int nums[],int k){
        int left=0,right=0,n=nums.length;
        int sum=0,maxlen=-1;
        while(right<n){
            sum+=nums[right];
            while(sum>k){
                sum-=nums[left];
                left++;
            }
            if(sum==k){
                maxlen=Math.max(maxlen,right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}