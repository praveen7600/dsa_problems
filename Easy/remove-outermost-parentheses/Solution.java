class Solution {
    public String removeOuterParentheses(String s) {
        int depth=0;
        int left=0;
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(ch=='('){
                depth++;
            }
            else{
                depth--;
            }
            if(depth==0){
                ans.append(s.substring(left+1,right));
                left=right+1;
            }
        }
        return ans.toString();
    }
}