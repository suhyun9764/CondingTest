import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. PriorityQueue에 scoville 저장
        // 2. peek한게 k보다 작거나 queue사이즈가 1보다 클때까지 순회
        Queue<Long> queue = new PriorityQueue<Long>();
        for(int i=0;i<scoville.length;i++){
            queue.add((long)scoville[i]);
        }
        
        int answer = 0;
        boolean find = false;
        while(queue.size()>=1){
            if(queue.peek()>=K){
                find = true;
                break;
            }
            
            if(queue.size()==1){
                break;
            }
            Long first = queue.poll();
            Long second = queue.poll();
            
            Long newScoville = first+(second*2);
            queue.add(newScoville);
            answer++;
        }
        if(find)
            return answer;
        
        return -1;
        
    }
}