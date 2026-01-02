import java.util.*;

class Solution {
    List[] map;
    int n;
    int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        dist = new int[n+1];
        Arrays.fill(dist,-1);
        dist[destination] = 0;
        map = new List[n+1];
        int[] answer = new int[sources.length];
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int a= roads[i][0];
            int b= roads[i][1];
            
            map[a].add(b);
            map[b].add(a);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{destination,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int pos = cur[0];
            int cost = cur[1];
            List<Integer> nodes = map[pos];
            for(int node : nodes){
                if(dist[node]!=-1) continue;
                dist[node] = cost+1;
                queue.add(new int[]{node,dist[node]});
            }
        }
        
        for(int i=0;i<sources.length;i++){
            int cur = sources[i];
            answer[i] = dist[cur];
        }
        
        return answer;
    }
}