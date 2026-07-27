class Pair{
    int index;
    int prefixsum;

    Pair(int index,int prefixsum){
        this.prefixsum=prefixsum;
        this.index=index;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> deque=new LinkedList<>();
        int n=nums.length;
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>=k){
                minlen=Math.min(minlen,i+1);
            }    
            while(!deque.isEmpty() && sum-deque.peekFirst().prefixsum>=k){
                minlen=Math.min(minlen,i-deque.peekFirst().index);
                deque.removeFirst();
            }
            while(!deque.isEmpty() && sum<deque.peekLast().prefixsum){
                deque.removeLast();
            }
            deque.offerLast(new Pair(i,sum));
        }
        return minlen==Integer.MAX_VALUE?-1:minlen;
    }
}

/*
while (!deque.isEmpty() && sum - deque.peekFirst().prefixsum >= k) {
                ans = Math.min(ans, i - deque.peekFirst().index);
                deque.pollFirst();
            }

            while (!deque.isEmpty() && sum <= deque.peekLast().prefixsum) {
                deque.pollLast();
            }
*/