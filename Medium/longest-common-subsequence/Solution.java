class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int ind1=1;ind1<n+1;ind1++){
            for(int ind2=1;ind2<m+1;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[n][m];
    }
    // public int LCS(String s1,String s2,int ind1,int ind2,int[][] dp){
    //     if(ind1==0 || ind2==0){
    //         return 0;
    //     }

    //     if(dp[ind1][ind2]!=-1){
    //         return dp[ind1][ind2];
    //     }

    //     if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
    //         return dp[ind1][ind2]=1+LCS(s1,s2,ind1-1,ind2-1,dp);
    //     }
    //     return dp[ind1][ind2]=Math.max(LCS(s1,s2,ind1-1,ind2,dp),LCS(s1,s2,ind1,ind2-1,dp));
    // }
}