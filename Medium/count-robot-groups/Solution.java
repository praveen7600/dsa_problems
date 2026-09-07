class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n=speed.length;
        int group=1;
        int groupspeed=speed[n-1];
        for(int i=n-2;i>=0;i--){
            if(position[i+1]-position[i]<=distance){
                continue;
            }
            if(speed[i]<=groupspeed){
                group++;
                groupspeed=speed[i];
            }
        }
        return group;
    }
}