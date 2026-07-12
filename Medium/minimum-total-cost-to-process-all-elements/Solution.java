class Solution {
    public int minimumCost(int[] nums, int k) {
        int available=k;
        int totalcost=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>available){
                int totalAllocation=0;
                totalAllocation+=(nums[i]/k);
                if(nums[i]%k>1){
                    totalAllocation++;
                }
                int temp=0;
                while(temp<totalAllocation){
                    totalcost+=temp;
                    available+=k;
                    temp++;
                }
            }
            available-=nums[i];
        }
        return totalcost;
    }
}