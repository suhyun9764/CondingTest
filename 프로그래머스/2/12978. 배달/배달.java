import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] costs = new int[N+1][N+1];
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            if(costs[a][b]!=0){
                costs[a][b] = Math.min(costs[a][b],cost);
                costs[b][a] = Math.min(costs[b][a],cost);
                continue;
            }
                
            costs[a][b] = cost;
            costs[b][a] = cost;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int[] fromACosts = new int[N+1];
        Arrays.fill(fromACosts,Integer.MAX_VALUE);
        fromACosts[1] = 0;
        
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curPos = cur[0];
            
            int[] nears = costs[curPos];
            
            for(int i=1;i<=N;i++){
                if(curPos==i) continue;
                if(costs[curPos][i]==0) continue;
                if(fromACosts[i]<=fromACosts[curPos]+costs[curPos][i]) continue;
                fromACosts[i] = fromACosts[curPos]+costs[curPos][i];
                pq.add(new int[]{i,fromACosts[i]});
            }
        }
        
        int answer = 0;
        System.out.println(Arrays.toString(fromACosts));
        for(int i=1;i<=N;i++){
            if(fromACosts[i]<=K) answer++;
        }

        return answer;
    }
}