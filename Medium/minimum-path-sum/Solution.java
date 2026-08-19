class Solution {
    public int minPathSum(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(mat,m-1,n-1,dp);
    }
    public int helper(int [][]mat,int row,int col,int[][]dp){
        if(row==0 && col==0){
            return mat[row][col];
        }
        if(row<0 || col<0){
            return Integer.MAX_VALUE;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up=0,right=0;
        up=helper(mat,row-1,col,dp);
        right=helper(mat,row,col-1,dp);
        return dp[row][col]=Math.min(up,right)+mat[row][col];
    }
}