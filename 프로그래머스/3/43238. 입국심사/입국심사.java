import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)n*times[times.length-1];
        
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            if(calc(times,mid)>=n){
                right = mid-1;
                answer = mid;
            }else{
                left = mid +1;
            }
        }
        
        return answer;
    }
    
    private long calc(int[] times,long mid){
        long cnt=0;
        for(int time : times){
            cnt += mid/time;
        }
        
        return cnt;
    }
}