class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
        helper(matrix,dp);

        int min=dp[n-1][0];
        for(int i=1;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
    public void helper(int[][] mat,int[][] dp){
        int n=mat.length;
        for(int i=0;i<n;i++){
            dp[0][i]=mat[0][i];
        }
        for(int row=1;row<n;row++){
            for(int col=0;col<n;col++){
                int up=dp[row-1][col];
                int leftdg=Integer.MAX_VALUE;
                int rightdg=Integer.MAX_VALUE;
                if(col>0){
                    leftdg= dp[row-1][col-1];
                }
                if(col<n-1){
                    rightdg= dp[row-1][col+1];
                }
                dp[row][col]= mat[row][col] + Math.min(Math.min(up,leftdg),rightdg);
            }
        }

        
    }
}