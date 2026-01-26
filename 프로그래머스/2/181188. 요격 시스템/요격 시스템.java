import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(a,b)->{
            if(a[1]==b[1])
                return a[0]-b[0];
            
            return a[1]-b[1];
        });
        
        int i = 0;
        int n = targets.length;
        int answer = 0;
        while(i<n){
            answer++;
            int[] cur = targets[i];
            int curEnd = cur[1];
            int t = i+1;
            while(t<n){
                int[] next = targets[t];
                int nextStart = next[0];
                if(nextStart>=curEnd) break;
                t++;
            }
            i = t;
        }
        
        return answer;
    }
}