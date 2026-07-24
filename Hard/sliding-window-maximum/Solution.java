class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int n=nums.length;
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int i=k;
        int [] result=new int[n-k+1];
        while(i<n){
            result[i-k]=nums[deque.getFirst()];
            if(!deque.isEmpty() && deque.getFirst()==i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            i++;
        }
        result[n-k]=nums[deque.getFirst()];
        return result;
    }
}