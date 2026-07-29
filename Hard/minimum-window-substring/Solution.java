class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int left=0;
        int right=0;
        int k=0;
        int startindex=-1;
        int endindex=-1;
        int minlen=Integer.MAX_VALUE;
        HashMap<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!mpp.containsKey(ch)){
                k++;
            }
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        while(right<s.length()){

            while(left<right && k==0){
                if(minlen>right-left+1){
                    startindex=left;
                    endindex=right;
                    minlen=right-left+1;
                }
                
                char leftchar=s.charAt(left);
                if(mpp.containsKey(leftchar)){
                    mpp.put(leftchar,mpp.get(leftchar)+1);
                    if(mpp.get(leftchar)>0){
                        k++;
                    }
                }
                left++;
            }

            char ch=s.charAt(right);
            if(mpp.containsKey(ch)){
                mpp.put(ch,mpp.get(ch)-1);
                if(mpp.get(ch)==0){
                    k--;
                }
            }
    
            right++;
        }

        while(left<right && k==0){
                if(minlen>right-left+1){
                    startindex=left;
                    endindex=right;
                    minlen=right-left+1;
                }
                
                char leftchar=s.charAt(left);
                if(mpp.containsKey(leftchar)){
                    mpp.put(leftchar,mpp.get(leftchar)+1);
                    if(mpp.get(leftchar)>0){
                        k++;
                    }
                }
                left++;
            }
        return minlen==Integer.MAX_VALUE?"":s.substring(startindex,endindex);
    }
}