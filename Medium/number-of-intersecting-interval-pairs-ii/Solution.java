class Solution {
    public long countIntersectingIntervals(int[][] arr) {
        int n=arr.length;
        long result=0;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i][0]);
        }
        for(int i=0;i<arr.length;i++){
            int upperbound=binarysearch(list,0,n-1,arr[i][1]);
            int rightlen=upperbound-i;
            result+=rightlen;
        }
        return result;
    }

    public int binarysearch(List<Integer> arr,int start,int end,int target){
        while(start<=end){
            int mid=(start+end)/2;
            if(arr.get(mid)<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return end;
    }
    
}