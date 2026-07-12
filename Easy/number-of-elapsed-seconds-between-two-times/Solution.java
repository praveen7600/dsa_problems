class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int seconds=0;
        int h1=Integer.parseInt(startTime.substring(0,2));
        int m1=Integer.parseInt(startTime.substring(3,5));
        int s1=Integer.parseInt(startTime.substring(6,8));
        int h2=Integer.parseInt(endTime.substring(0,2));
        int m2=Integer.parseInt(endTime.substring(3,5));
        int s2=Integer.parseInt(endTime.substring(6,8));
        int [] time1=new int[3];
        int [] time2=new int[3];
        time1[0]=h1;
        time1[1]=m1;
        time1[2]=s1;
        time2[0]=h2;
        time2[1]=m2;
        time2[2]=s2;
        return countSecondsTillNow(time1)-countSecondsTillNow(time2);

    }

    public int countSecondsTillNow(int [] time){
        int endHour=time[0];
        int endMin=time[1];
        int endSec=time[2];
        int hour=0;
        int min=0;
        int sec=0;
        int totalSec=0;
        while(hour<endHour){
            totalSec+=3600;
            hour++;
        }
        while(min<endMin){
            totalSec+=60;
            min++;
        }
        while(sec<endSec){
            totalSec++;
            sec++;
        }
        return totalSec;
    }
}