class Solution {
    public String[] largestString(int[] nums) {
        String result[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){

            int n=nums[i];
            StringBuilder sb=new StringBuilder();
            while(n>1){
                int pow=powerOf2(n);
                if(pow == 26){
                    sb.append("zz");
                } else {
                    sb.append((char)(pow + 'a'));
                }
                n -= (int)Math.pow(2, pow);
            }
            if(n == 1){
                sb.append('a');
            }
            result[i]=sb.toString();
        }

        return result;
    }

    

    public int powerOf2(int n){
        int pow=1;
        int count=0;
        while(pow*2<=n){
            pow*=2;
            count++;
        }
        return count;
    }
}