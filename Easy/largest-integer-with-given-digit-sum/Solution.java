class Solution {
    public int largestInteger(int n, int s) {
        if(s==0){
            return 0;
        }
        if(s>n*9){
            return -1;
        }
        int temp=s;
        StringBuilder str=new StringBuilder();
        while(temp>9){
            str.append("9");
            temp-=9;
        }
        if(temp>0){
            str.append(temp);
        }
        int len=str.length();
        while(len<n){
            str.append("0");
            len++;
        }
        return Integer.parseInt(str.toString());
    }
}