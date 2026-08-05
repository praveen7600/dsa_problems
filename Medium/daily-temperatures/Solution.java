class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        Deque<Integer> deque=new LinkedList<>();
        for(int i=n-1;i>=0;i--){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.removeLast();
            }
            result[i]=deque.isEmpty()?0:deque.peekLast()-i;
            deque.offerLast(i);
        }
        return result;
    }
}