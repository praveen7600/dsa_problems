class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int base=0;
        int extra=0;
        int n=nums.length;
        HashMap<Pair,Integer> map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                base++;
            }
            else{
                int min=Math.min(nums[i],nums[i+1]);
                int max=Math.max(nums[i],nums[i+1]);
                Pair p=new Pair(min,max);
                map.put(p,map.getOrDefault(p,0)+1);
                if(map.get(p)>extra){
                    extra=map.get(p);
                }
            }
        }
        return base+extra;
    }
}