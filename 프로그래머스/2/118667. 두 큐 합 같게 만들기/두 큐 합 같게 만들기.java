

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 큐1, 큐2합 각각 구하기
        long sum1 = 0;
        for(int i=0;i<queue1.length;i++){
            sum1+=queue1[i];    
        }
        
        long sum2 = 0;
        for(int i=0;i<queue2.length;i++){
            sum2 += queue2[i];
        }
        // 큐1+큐2합 구하기
        long total = sum1+sum2;
        // 만약 2로 나누어떨어지지 않으면 -1 리턴
        if(total%2!=0)
            return -1;
        // target = 큐1+큐2 / 2
        long target = total/2;
        // 큐두개 이어붙혀서 배열만들기
        int[] arr = new int[queue1.length*2];
        for(int i=0;i<queue1.length;i++){
            arr[i] = queue1[i];
        }
        
        for(int i=0;i<queue1.length;i++){
            arr[queue1.length+i] = queue2[i];
        }
        // left = 큐1의 처음, right = 큐2의 처음
        int left = 0;
        int right = queue1.length;
        
        int cnt = 0;
        // 큐1의 합이 크다면 left++, 작다면 right ++
        while(left<arr.length&&right<arr.length){
            if(sum1==target)
                return cnt;
            
            if(sum1<target){
                sum1+=arr[right++];
                cnt++;
                continue;
            }
            
            sum1-=arr[left++];
            cnt++;
        }
        // 만약 target에 도달할 경우 cnt 리턴
        return -1;
    }
}