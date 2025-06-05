import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Task> q = new ArrayDeque<>();
        
        for(int i=0;i<priorities.length;i++){
            pq.offer(priorities[i]);
            q.offer(new Task(priorities[i],i));
        }
        
        int answer = 0;
        int num = 0;
        while(pq.size()!=0){
            int currentPr = pq.poll();
            while(currentPr!=q.peek().pr){
                Task tsk = q.poll();
                q.offer(tsk);
            }
            Task currentTask = q.poll();
            num++;
            if(currentTask.order == location)
                answer = num;
        }
        
        return answer;
    }
}

class Task{
        int pr;
        int order;
        
        public Task(int pr, int order){
            this.pr = pr;
            this.order =order;
        }
    }