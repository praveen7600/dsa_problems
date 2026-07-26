class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,prod1=1,prod2=1;
        for(int i=n-1;i>n-4;i--){
            prod1*=nums[i];
        }
        for(int i=0;i<2;i++){
            prod2*=nums[i];
        }
        prod2*=nums[n-1];
        return Math.max(prod1,prod2);
    }
}