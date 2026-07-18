class Solution {
    public int totalFruit(int[] nums) {
        int maxlen=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int left=0;
        int right=0;
        int n=nums.length;
        while(right<n){
            
            if(mpp.size()>2){
                mpp.put(nums[left],mpp.getOrDefault(nums[left],0)-1);
                if(mpp.get(nums[left])==0){
                    mpp.remove(nums[left]);
                }
                left++;
            }
            int cur=nums[right];
            mpp.put(cur,mpp.getOrDefault(cur,0)+1);
            if(mpp.size()<=2){
                maxlen=Math.max(maxlen,right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}