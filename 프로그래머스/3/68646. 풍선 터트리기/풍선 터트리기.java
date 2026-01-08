import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if(n<=3){
            return n;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for(int i=2;i<n;i++){
            pq.add(a[i]);
            queue.add(a[i]);
        }
        int leftMin = a[0];
        int answer = 2;
        for(int i=1;i<n-1;i++){
            int cur = a[i];
            int rightMin = pq.peek();
            if(Math.max(cur,Math.max(rightMin,leftMin))!=cur)
                answer++;
            
            leftMin = Math.min(leftMin,cur);
            int next = queue.poll();
            set.add(next);
            while(set.contains(pq.peek())){
                pq.poll();
            }
        }
        
        return answer;
        
    }
}