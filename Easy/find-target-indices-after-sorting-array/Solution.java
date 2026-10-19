class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int start=lowerBound(nums,target);
        int end=upperBound(nums,target);

        if(start==-1 || end==-1){
            return list;
        }
        for(int i=start;i<=end;i++){
            list.add(i);
        }

        return list;
    }

    public int lowerBound(int[] nums,int target){
        int ind=-1,n=nums.length;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                ind=mid;
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ind;
    }

    public int upperBound(int[] nums,int target){
        int ind=-1,n=nums.length;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                ind=mid;
                start=mid+1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ind;
    }
}