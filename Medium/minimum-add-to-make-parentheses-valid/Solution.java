class Solution {
    public int minAddToMakeValid(String s) {
        int total=0;
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push('(');
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    total+=1;
                }
            }
        }
        return total+=stack.size();
    }
}