class Solution {
    public int countRotations(String s, int k) {
        int n=s.length();

        int adjcount=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                adjcount++;
            }
        }
        
        
        if(s.charAt(n-1)==s.charAt(0)){
            adjcount++;
        }
        
        if(k==adjcount){
            return n-adjcount;
        }

        if(k==adjcount-1){
            return adjcount;
        }
        

        return 0;

       
    }

    
}