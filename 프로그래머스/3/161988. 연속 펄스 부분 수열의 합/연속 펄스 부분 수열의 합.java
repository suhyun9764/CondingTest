import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        // 홀수 인덱스를 *-1
        int n = sequence.length;
        for(int i=1;i<n;i+=2){
            sequence[i]*=-1;
        }
        
        long answer = getMaxSum(sequence);
        
        for(int i=0;i<n;i++){
            sequence[i]*=-1;
        }
        
        answer = Math.max(answer,getMaxSum(sequence));
        return answer;
    }
    
    private long getMaxSum(int[] s){
        long[] sumArr = new long[s.length];
        sumArr[0] = s[0];
        long max = s[0];
        long min = s[0];
        int maxIndex = 0;
        int minIndex = 0;
        for(int i=1;i<s.length;i++){
            sumArr[i] = sumArr[i-1]+s[i];
            if(sumArr[i]>=max){
                max = sumArr[i];
                maxIndex = i;
            }
            
            if(sumArr[i]<min){
                min = sumArr[i];
                minIndex = i;
            }
        }
        
        return Math.max(max,max-min);
        
    }
}