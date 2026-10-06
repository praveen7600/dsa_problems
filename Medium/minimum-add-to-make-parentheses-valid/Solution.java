class Solution {
    public int minAddToMakeValid(String s) {
        int total=0;
        int n=s.length();
        int openbracket=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                openbracket++;
            }
            else{
                if(openbracket>0){
                    openbracket--;
                }
                else{
                    total+=1;
                }
            }
        }
        return total+=openbracket;
    }
}