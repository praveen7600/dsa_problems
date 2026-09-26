class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n=knowledge.size();
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> list=knowledge.get(i);
            map.put(list.get(0),list.get(1));
        }

        StringBuilder result=new StringBuilder();

        int i=0;
        while(i<s.length()){
            String bracket="";
            if(s.charAt(i)=='('){
                i++;
                while(s.charAt(i)!=')'){
                    bracket+=s.charAt(i);
                    i++;
                }
                i++;
            }
            if(!bracket.equals("")){
                if(!map.containsKey(bracket)){
                    result.append("?");
                }
                else{
                    result.append(map.get(bracket));
                }
                bracket="";

            }
            if(i<s.length() && s.charAt(i)=='('){
                continue;
            }
            if(i<s.length()){
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}