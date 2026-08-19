class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {

        int m=mat.length;
        int n=mat[0].length;
        if(mat[0][0]==1) return 0;
        int [][]dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        if(mat[0][0]!=1) 
            dp[0][0]=1;
        return helper(m-1,n-1,mat,dp);
        
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