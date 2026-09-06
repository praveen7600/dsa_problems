class Solution {
    public int minCost(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][][][] dp=new int[n][m][5][k+1];
        for(int row[][][]:dp){
            for(int[][] col:row){
                for(int[]f:col){
                    Arrays.fill(f,-1);
                }
            }
        }
        int res= helper(n-1,m-1,k,mat,0,0,dp);
        return res==Integer.MAX_VALUE?-1:res;
    }

    public int helper(int row,int col, int k,int[][] mat,int prevmove,int move,int dp[][][][]){
        int n=mat.length;
        int m=mat[0].length;
        if(row<0 || col<0 || row>=n || col>=m || move>k){
            return Integer.MAX_VALUE;
        }

        if(row==0 && col==0){
            return mat[row][col];
        }

        if (dp[row][col][prevmove][move]!=-1){
            return dp[row][col][prevmove][move];
        }

        /*
        0-start
        1-left
        2-up
        3-right
        4-down
        */
        int left=0,up=0;
        if(prevmove!=1 && prevmove!=0){
            int temp=move+1;
            left=helper(row-1,col,k,mat,1,temp,dp);
        }
        else{
            left=helper(row-1,col,k,mat,1,move,dp);
        }
        if(prevmove!=2 && prevmove!=0){
            int temp=move+1;
             up=helper(row,col-1,k,mat,2,temp,dp);
        }
        else{
            up=helper(row,col-1,k,mat,2,move,dp);

        }

        int right=0,down=0;
        if(prevmove!=3 && prevmove!=0){
            int temp=move+1;
            right=helper(row+1,col,k,mat,3,temp,dp);
        }
        else{
            right=helper(row+1,col,k,mat,3,move,dp);
        }
        if(prevmove!=4 && prevmove!=0){
            int temp=move+1;
             down=helper(row,col+1,k,mat,4,temp,dp);
        }
        else{
            down=helper(row,col+1,k,mat,4,move,dp);

        }
        
        int min=Math.min(Math.min(Math.min(left,up),down),right);
        return dp[row][col][prevmove][move]=min+(min==Integer.MAX_VALUE?0:mat[row][col]);
    }
}