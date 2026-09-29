class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int balance=m+n;
        Boolean dp[][][]=new Boolean[n][m][balance];
        
        return helper(grid,0,0,0,dp);
    }

    public boolean helper(char[][] grid,int i,int j,int balance,Boolean[][][]dp){
        
        if(i>=grid.length || j>=grid[0].length ){
            return false;
        }
        
        int newbalance=balance;
        if(grid[i][j]=='('){
            newbalance=balance+1;
        }
        if(grid[i][j]==')'){
            newbalance=balance-1;
        }
        if(newbalance<0){
            return false;
        }

        if(dp[i][j][balance]!=null){
            return dp[i][j][balance];
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return newbalance==0;
        }
        boolean right=helper(grid,i,j+1,newbalance,dp);
        boolean down=helper(grid,i+1,j,newbalance,dp);
        return dp[i][j][balance]= right || down;
    }

    
}