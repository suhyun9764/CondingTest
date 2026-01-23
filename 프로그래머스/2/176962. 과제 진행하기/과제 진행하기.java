import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<HomeWork> pq = new PriorityQueue<>();
        Stack<HomeWork> stack = new Stack<>();
        for(String[] plan : plans){
            pq.add(new HomeWork(plan));
        }
        
        String[] answer = new String[plans.length];
        int cnt = 0;
        while(!pq.isEmpty()){
            HomeWork hw = pq.poll();
            HomeWork next = null;
            if(!pq.isEmpty()){
                next = pq.peek();
            }
            
            if(next==null){
                answer[cnt++] = hw.name;
                break;
            }
            
            if(hw.start+hw.need>next.start){
                hw.need -= next.start-hw.start;
                stack.push(hw);
            }else{
                answer[cnt++] = hw.name;
                int remain = next.start-(hw.start+hw.need);
                while(remain>0&&!stack.isEmpty()){
                    HomeWork ing = stack.peek();
                    int min = Math.min(ing.need, remain);
                    remain-=min;
                    ing.need -=min;
                    if(ing.need==0){
                        answer[cnt++] = stack.pop().name;
                    }
                }
            }
        }
        
        while(!stack.isEmpty()){
            answer[cnt++] = stack.pop().name;
        }
        
        return answer;
    }
}

class HomeWork implements Comparable<HomeWork>{
    String name;
    int start;
    int need;
    
    public HomeWork(String[] info){
        name = info[0];
        String[] field = info[1].split(":");
        start = Integer.parseInt(field[0])*60+Integer.parseInt(field[1]);
        need = Integer.parseInt(info[2]);
    }
    
    public int compareTo(HomeWork o){
        return this.start-o.start;
    }
}