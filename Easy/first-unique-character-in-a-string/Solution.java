class Solution {
    public int firstUniqChar(String s) {
        int index=-1,n=s.length();
        int charArr[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            charArr[ch-'a']++;
        }

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(charArr[ch-'a']==1){
                index=i;
                break;
            }
        }
        return index;
    }
}