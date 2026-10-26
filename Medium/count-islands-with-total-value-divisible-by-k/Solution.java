class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        long count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    long res=dfs(grid,vis,i,j);
                    if(res!=0 && res%k==0){
                        count++;
                    }
                }
            }
        }
        return (int)count;
    }

    public long dfs(int[][] grid,boolean[][] vis,int row,int col){

        vis[row][col]=true;

        if(grid[row][col]==0){
            return 0;
        }

        int n=grid.length;
        int m=grid[0].length;
        
        int[] nr={1,0,-1,0};
        int[] nc={0,1,0,-1};
        long ans=0;
        for(int i=0;i<4;i++){
            int nextrow=row+nr[i];
            int nextcol=col+nc[i];
            if(nextrow>=0 && nextrow<n && nextcol>=0 && nextcol<m && grid[nextrow][nextcol]!=0 && !vis[nextrow][nextcol]){
                ans+=dfs(grid,vis,nextrow,nextcol);
            }
        }

        return grid[row][col]+ans;
    }

}