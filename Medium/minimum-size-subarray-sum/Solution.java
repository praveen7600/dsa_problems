class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int n=nums.length;
        int left=0,right=0;
        int cursum=0;
        while(right<n){
            
            cursum+=nums[right];
             while(cursum>=target){
                minlen=Math.min(minlen,right-left+1);
                cursum-=nums[left];
                left++;
            }
            right++;
        }
        
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}