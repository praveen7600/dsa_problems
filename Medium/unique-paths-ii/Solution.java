class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {

        int m=mat.length;
        int n=mat[0].length;
        if(mat[0][0]==1) return 0;
        int [][]dp=new int[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col]==1){
                    dp[row][col]=0;
                }
                else if(row==0 && col==0){
                    dp[row][col]= 1;
                }
                else{
                    int up=0,right=0;
                    if(row>0) up=dp[row-1][col];
                    if(col>0) right=dp[row][col-1];
                    dp[row][col]= up+right;
                }
            }
        }
        return dp[m-1][n-1];
        
    }
    public int helper(int row,int col,int[][] mat,int[][] dp){
        if(row<0 || col<0 || mat[row][col]==1){
            return 0;
        }

        if(row==0 && col==0){
            return 1;
        }

        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int up=0,right=0;
        up=helper(row-1,col,mat,dp);
        right=helper(row,col-1,mat,dp);
        return dp[row][col]= up+right;
    }
}