class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        
        int maxwidth=0;
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deque.isEmpty() || nums[deque.peekLast()]>nums[i]){
                deque.offerLast(i);
            }
        }

        for(int j=n-1;j>=0;j--){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[j]){
                maxwidth=Math.max(maxwidth,j-deque.peekLast());
                deque.removeLast();
            }
        }
        return maxwidth;
    }
}