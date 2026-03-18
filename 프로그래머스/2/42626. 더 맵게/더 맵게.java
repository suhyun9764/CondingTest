import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        while(pq.peek()<K&&pq.size()>1){
            int min = pq.poll();
            int sec = pq.poll();
            int newFood = min+(sec*2);
            pq.add(newFood);
            answer++;
            
        }
        
        if(pq.peek()<K) return -1;
        return answer;
    }
}