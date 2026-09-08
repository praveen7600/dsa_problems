class Solution {
    public int countGoodRotations(int[] arr) {
        int n=arr.length;
        long leftsum=0;
        long rightsum=0;
        int result=0;
        for(int i=0;i<n/2;i++){
            leftsum+=arr[i];
        }
        for(int i=n/2;i<n;i++){
            rightsum+=arr[i];
        }

        if(leftsum>rightsum){
            result++;
        }

        for(int i=0;i<n-1;i++){
            int leftind=i%n;
            int rightind=(i+(n/2))%n;
            leftsum-=arr[leftind];
            leftsum+=arr[rightind];
            rightsum+=arr[leftind];
            rightsum-=arr[rightind];
            if(leftsum>rightsum){
                result++;
            }
        }
        return result;
    }
}