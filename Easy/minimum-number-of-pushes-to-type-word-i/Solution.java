class Solution {
    public int minimumPushes(String word) {
        int result=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        int ind=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!mpp.containsKey(ch)){
                ind++;
                mpp.put(ch,ind);
            }
            if(mpp.get(ch)>24){
                result+=4;
            }
            else if(mpp.get(ch)>16){
                result+=3;
            }
            else if(mpp.get(ch)>8){
                result+=2;
            }
            else{
                result+=1;
            }
        }
        return result;
    }
}