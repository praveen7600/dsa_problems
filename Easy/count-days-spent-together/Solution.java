class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveDay=Math.max(getDay(arriveAlice),getDay(arriveBob));
        int leaveDay =Math.min(getDay(leaveAlice),getDay(leaveBob));

        return Math.max(0,leaveDay-arriveDay+1);
    }

    public int getDay(String date){
        int[] days={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int d1=Integer.parseInt(date.substring(3,5));
        int m1=Integer.parseInt(date.substring(0,2));
        int total=0;
        for(int i=0;i<m1;i++){
            total+=days[i];
        }
        total+=d1;
        return total;
    }
}