import java.util.*;

class Solution {
    class Job implements Comparable<Job>{
        int cost;
        int requestTime;
        int order;
        
        public Job(int[] info,int order){
            this.cost = info[1];
            this.requestTime = info[0];
            this.order = order;
            
        }
        
        public int compareTo(Job o){
            if(this.cost==o.cost){
                if(this.requestTime==o.requestTime)
                    return this.order-o.order;
                return this.requestTime-o.requestTime;
            }
                
            return this.cost-o.cost;
        }
    }
    public int solution(int[][] jobs) {
        // 1. 작업 소요시간 짧은것
        // 2. 작업의 요청 시각이 빠른것
        // 3. 작업의 번호가 작은 것
        int n =jobs.length;
        PriorityQueue<Job> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]); 
        int i = 0;
        int time = 0;
        int total = 0;
        while(i<n||!pq.isEmpty()){
            while(i<n&&jobs[i][0]<=time){
                pq.add(new Job(jobs[i],i++));
            }
            
            if(pq.isEmpty()){
                time = jobs[i][0];
                continue;
            }
            
            Job job = pq.poll();
            int endTime = time+job.cost;
            total += endTime-job.requestTime;
            time+=job.cost;
            // System.out.println(job.order +" : "+(endTime-job.cost)+"->"+endTime);
        }
        
        return total/n;
    }

}