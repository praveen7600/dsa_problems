class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxlen=Integer.MIN_VALUE;
        Deque<Integer> min_deque=new LinkedList<>();
        Deque<Integer> max_deque=new LinkedList<>();

        int n=nums.length,l=0;
        for(int r=0;r<n;r++){
            //Min Deque to Store Minimum values (monotonically increasing)
            while(!min_deque.isEmpty() && nums[min_deque.peekLast()]>nums[r]){
                min_deque.removeLast();
            }
            while(!max_deque.isEmpty() && nums[max_deque.peekLast()]<nums[r]){
                max_deque.removeLast();
            }
            
            min_deque.addLast(r);
            max_deque.addLast(r);
            
            while(!max_deque.isEmpty() && !min_deque.isEmpty() && nums[max_deque.peekFirst()]-nums[min_deque.peekFirst()]>limit){
                if(!min_deque.isEmpty() && nums[min_deque.peekFirst()]==nums[l]){
                    min_deque.removeFirst();
                }
                if(!max_deque.isEmpty() && nums[max_deque.peekFirst()]==nums[l]){
                    max_deque.removeFirst();
                }
                l++;
            }

            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}