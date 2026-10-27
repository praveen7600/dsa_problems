class Solution {
    public String[] createGrid(int m, int n) {
        String[] res=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder str=new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==0 || j==n-1){
                    str.append(".");
                }
                else{
                    str.append("#");
                }
            }
            res[i]=str.toString();
        }
        return res;
    }
}