import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // Queue 생성
        Queue<Integer> queue = new ArrayDeque<>();
        // bridge_length 만큼 0 집어넣기(빈차)
        for(int i=0;i<bridge_length;i++){
            queue.add(0);
        }
        // int sum = 0 선언
        int sum = 0;
        int curTruck = 0;
        int answer = 0;
        while(!queue.isEmpty()){
            int out = queue.poll();
            answer++;
            sum-=out;
            if(curTruck>=truck_weights.length) continue;
            int next = truck_weights[curTruck];
            if(sum+next<=weight){
                queue.add(next);
                sum+=next;
                curTruck++;
            }else{
                queue.add(0);
            }
        }
        return answer;
    }
}