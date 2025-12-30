import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        // 인데스 0 부터 끝까지 탐색
        // start = 0으로 초기화
        // min = int max
        // 현재까지의 합이 k보다 작다면 다음으로
        // 현재까지 합이 k보다 크다면 
            // k보다 작거나 같아질때까지 start++하고 빼기
            // 만약 k라면 end = 현재 인덱스
        // 현재까지 합이 k라면 end = 현재 인덱스
        // 만약 min = Math.min(min,end-start);
        
        int min = Integer.MAX_VALUE;
        int n = sequence.length;
        int start = 0;
        int answerStart= 0;
        int answerEnd = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=sequence[i];
            // System.out.println(i+" : "+sum);
            if(sum==k){
                if(min>i-start){
                    min = i-start;
                    answerStart = start;
                    answerEnd = i;
                }
                continue;
            }
            
            if(sum>k){
                // System.out.println("come");
                while(start<=i&&sum>k){
                    sum-=sequence[start];
                    start++;
                }
                // System.out.println(start+" "+sum);
                if(sum==k){
                    if(min>i-start){
                        min = i-start;
                        answerStart = start;
                        answerEnd = i;
                    }
                
                }
            }
        }
        
        return new int[]{answerStart,answerEnd};
    }
}