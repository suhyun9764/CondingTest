import java.util.*;

class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            int playTime = convertToSecond(play_time);
            int advTime = convertToSecond(adv_time);

            long[] timeLine = new long[playTime+1];

            for(int i=0;i<logs.length;i++){
                String curLog = logs[i];
                int start = getStartTime(curLog);
                int end = getEndTime(curLog);

                timeLine[start]+=1;
                timeLine[end]-=1;
            }

            for(int i=1;i<=playTime;i++){
                timeLine[i] += timeLine[i-1];
            }

            for(int i=1;i<=playTime;i++){
                timeLine[i] += timeLine[i-1];
            }

            long max =timeLine[advTime-1];
            int startTime = 0;
            for(int i=advTime;i<=playTime;i++){
                long total = timeLine[i]-timeLine[i-advTime];
                if(total>max) {
                    max = total;
                    startTime = i-advTime+1;
                }
            }

            return toStringTime(startTime);
        }

        private String toStringTime(int startTime) {
            int hour = startTime/3600;
            int minute = (startTime%3600)/60;
            int second = startTime%60;

            return String.format("%02d:%02d:%02d",hour,minute,second);
        }


        private int convertToSecond(String time) {
            String[] fields = time.split(":");
            return Integer.parseInt(fields[0])*60*60+Integer.parseInt(fields[1])*60+Integer.parseInt(fields[2]);
        }

        private int getStartTime(String curLog) {
            return convertToSecond(curLog.split("-")[0]);
        }

        private int getEndTime(String curLog) {
            return convertToSecond(curLog.split("-")[1]);
        }
    }