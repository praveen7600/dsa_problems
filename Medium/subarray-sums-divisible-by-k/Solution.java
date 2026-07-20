class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0,n=nums.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int cursum=0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            cursum+=nums[i];
            int rem=((cursum%k)+k)%k;
            if(mpp.containsKey(rem)){
                count+=mpp.get(rem);
            }
            mpp.put(rem,mpp.getOrDefault(rem,0)+1);
        }
        return count;
    }
}