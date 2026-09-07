class Solution {
    public int countRotations(String s, int k) {
        int n=s.length();
        int result=0;
        for(int i=0;i<s.length();i++){
            StringBuilder str=new StringBuilder();
            str.append(s.substring(i,n)).append(s.substring(0,i));
            if(helper(str.toString())==k){
                result++;
            }
        }
        return result;
    }

    public int helper(String s){
        int n=s.length();
        int adjcount=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                adjcount++;
            }
        }
        return adjcount;
    }
}