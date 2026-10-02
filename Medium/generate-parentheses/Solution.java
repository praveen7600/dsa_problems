class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<String>();
        helper("",0,0,n,result);
        return result;
    }
    public  void helper(String up,int open,int close,int n,List<String> result){
        if(open==n && close==n){
            result.add(up);
            return;
        }
        if(open<n){
            helper(up+"(",open+1,close,n,result);
        }
        if(close<open && close<n){
            helper(up+")",open,close+1,n,result);
        }
    }

}