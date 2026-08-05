class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        Stack<Integer> deque=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!deque.isEmpty() && nums[deque.peek()]<=nums[i]){
                deque.pop();
            }
            result[i]=deque.isEmpty()?0:deque.peek()-i;
            deque.push(i);
        }
        return result;
    }
}