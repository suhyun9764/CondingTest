import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSecond(play_time);
        int advTime = toSecond(adv_time);
        long[] timeLine = new long[playTime+2];
        for(String log : logs){
            String[] fields = log.split("-");
            int start = toSecond(fields[0]);
            // System.out.println("Start :"+fields[0]+"="+start);
            int end = toSecond(fields[1]);
             // System.out.println("End :"+fields[1]+"="+end);
            timeLine[start+1]++;
            timeLine[end+1]--;
        }
        
        for(int i=1;i<timeLine.length;i++){
            timeLine[i] += timeLine[i-1];
        }
        
        
        for(int i=1;i<timeLine.length;i++){
            timeLine[i] += timeLine[i-1];
        }
        
        
        long max = 0;
        int start = 0;
        for(int i=0;i<playTime;i++){
            int end = i+advTime;
            if(end>playTime) break;
            long totalWatchingTime = timeLine[end]-timeLine[i];
            if(max<totalWatchingTime){
                max=totalWatchingTime;
                // System.out.println(i+" : "+toPrint(totalWatchingTime));
                start = i;
            }
        }
        
        return toPrint(start);
        
    }
    
    private int toSecond(String time){
        String[] fields = time.split(":");
        int hour = Integer.parseInt(fields[0]);
        int minute = Integer.parseInt(fields[1]);
        int second = Integer.parseInt(fields[2]);
        
        return hour*3600+minute*60+second;
    }
    
    private String toPrint(int second){
        int hour = second/3600;
        int minute = (second-(hour*3600))/60;
        int sec = (second-(hour*3600)-(minute*60))%60;
        
        return String.format("%02d:%02d:%02d",hour,minute,sec).toString();
    }
}