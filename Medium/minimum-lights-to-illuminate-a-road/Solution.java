
class Solution {
    public int minLights(int[] nums) {
        int n=nums.length;
        ArrayList<int []> intervals=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>=1){
                int left=Math.max(0,i-nums[i]);
                int right=Math.min(n-1,i+nums[i]);
                intervals.add(new int[]{
                    left,right
                });
            }
        }

        if(intervals.size()==0){
            return (n+2)/3;
        }

        intervals.sort((a,b)->Integer.compare(a[0],b[0]));

        ArrayList<int []> merged=new ArrayList<>();

        int start=intervals.get(0)[0];
        int end=intervals.get(0)[1];

        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i)[0]<=end+1){
                end = Math.max(end, intervals.get(i)[1]);
            }
            else{
                merged.add(new int[]{start,end});
                start=intervals.get(i)[0];
                end=intervals.get(i)[1];
            }
        }
        merged.add(new int[]{start,end});

        int reqBulb=0;

        reqBulb+=(merged.get(0)[0]+2)/3;

        for(int i=1;i<merged.size();i++){
            int gap=merged.get(i)[0]-merged.get(i-1)[1]-1;
            reqBulb+=(gap+2)/3;
        }

        reqBulb+= ((n-1) -(merged.get(merged.size()-1)[1])+2)/3;
        return reqBulb;

    }
}