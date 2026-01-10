import java.util.*;

class Solution {
    int[] diffs;
    int[] times;
    long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        // 이분 탐색
      
        int max = 0;
    
        for(int i=0;i<diffs.length;i++){
            max = Math.max(max,diffs[i]);
        }
        // System.out.println(max);
        int l = 1;
        int r = max;
        while(l<r){
            int mid = (l+r)/2;
            if(limit>=getTotalTime(mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        
        return l;
    }
    
    private long getTotalTime(int level){
          // 각 단계 걸리는 시간 
        /*
            if(diff>level){
                2*(time+prev)+time
            }else{
                time
            }
        */
        long total = 0;
        long prev = 0;
        for(int i=0;i<diffs.length;i++){
            int curDiff = diffs[i];
            int curTime = times[i];
            if(curDiff>level){
                total+= (curDiff-level)*(curTime+prev)+curTime;
            }else{
                total+=curTime;
            }
            prev = curTime;
        }
        
        return total;
    }
}