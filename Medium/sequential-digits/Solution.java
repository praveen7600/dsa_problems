class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        String s="123456789";
        int n=s.length();
        String start=Integer.toString(low);
        String end=Integer.toString(high);
        int i=start.length();
        int j=end.length();
        while(i<=j){
            for(int k=i;k<=n;k++){
                String temp=s.substring(k-i,k);
                int cur=Integer.parseInt(temp);
                if(cur>=low && cur<=high){
                    list.add(cur);
                }
                else if(cur>high){
                    break;
                }
            }
            i++;
        }
        return list;
    }
}