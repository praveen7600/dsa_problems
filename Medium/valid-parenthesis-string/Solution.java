class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Boolean[][]dp=new Boolean[n][n];
        
        return helper(0,0,s,dp);
    }

    public boolean helper(int ind,int count,String s,Boolean[][] dp){
        
        if(count<0){
            return false;
        }

        if(ind==s.length()){
            return count==0;
        }

        if(dp[ind][count]!=null){
            return dp[ind][count];
        }

        char ch=s.charAt(ind);
        if(ch=='('){
            return dp[ind][count]=helper(ind+1,count+1,s,dp);
        }
        else if(ch==')'){
            return dp[ind][count]=helper(ind+1,count-1,s,dp);
        }
        return dp[ind][count]=helper(ind+1,count-1,s,dp) || helper(ind+1,count,s,dp) || helper(ind+1,count+1,s,dp);
        
    }
}