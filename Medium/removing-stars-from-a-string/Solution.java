class Solution {
    public String removeStars(String s) {
        StringBuilder temp=new StringBuilder();
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(!stack.isEmpty() && s.charAt(i)=='*'){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            temp.append(stack.pop());
        }
        return temp.reverse().toString();
    }
}