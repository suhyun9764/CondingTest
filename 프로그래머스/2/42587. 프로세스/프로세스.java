import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {

        // Queue 생성
        Queue<Process> queue = new ArrayDeque<>();
        // priorities 순회
        for(int i=0;i<priorities.length;i++){
                    // 큐에 삽입
            queue.add(new Process(i,priorities[i]));
        }
        // priorities 정렬
        Arrays.sort(priorities);
        // location이 나올때까지 while
        int cur = -1;
        int turn = 0;
        
        int answer = -1;
        while(!queue.isEmpty()){
            Process process = queue.poll();
            if(process.priority!=priorities[priorities.length-1-turn]){
                queue.add(process);
                continue;
            }
            
            turn++;
            if(process.order==location){
                answer = turn;
                break;
            }
        }
        // 현재 poll한 값이 currentPriority가 아닌 경우 push
        
        return answer;
    }
}
// process 객체 생성
class Process{
    int order;
    int priority;
    
    public Process(int order, int priority){
        this.order = order;
        this.priority = priority;
    }
}