class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            int ch=num.charAt(i)-'0';
            while(!deque.isEmpty() && deque.peekLast()>ch && k>0){
                deque.removeLast();
                k--;
            }
            deque.offerLast(ch);
        }
        while(k>0){
            deque.removeLast();
            k--;
        }
        while(!deque.isEmpty() && deque.peekFirst()==0){
            deque.removeFirst();
        }
        StringBuilder ans=new StringBuilder();
        while(!deque.isEmpty()){
            ans.append(deque.removeFirst());
        }
        return ans.isEmpty()?"0":ans.toString();
    }
}