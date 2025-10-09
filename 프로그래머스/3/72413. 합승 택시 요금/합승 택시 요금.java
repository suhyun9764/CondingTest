import java.util.*;

class Solution {
    int n;
    int[][] prices;
    int[][] minimumPrices;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 1. s->a + s-> b
        // 2. s->a + a ->b
        // 3. s->b + b ->a
        this.n = n;
        prices = new int[n+1][n+1];
        for(int[] fare : fares){
            int start = fare[0];
            int end = fare[1];
            int price = fare[2];
            
            prices[start][end] = price;
            prices[end][start] = price;
        }
        
        int answer = Integer.MAX_VALUE;
        minimumPrices = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(minimumPrices[i],-1); 
        }
        getMinimumPriceGraph(s);
        getMinimumPriceGraph(a);
        getMinimumPriceGraph(b);
        
        for(int i=1;i<=n;i++){
            int sToI = minimumPrices[s][i];
            // if(minimumPrices[s][i]==-1||minimumPrices[a][i]==-1||minimumPrices[i][b]==-1||minimumPrices[b][i]==-1){
            //     getMinimumPriceGraph(i);
            // }
            int iToA = minimumPrices[a][i];
            int iToB = minimumPrices[b][i];
            answer = Math.min(sToI+iToA+iToB,answer);
        }
        
        return answer;
    }
    
    
    private void getMinimumPriceGraph(int start){
        int[] targets = new int[n+1];
        Arrays.fill(targets,Integer.MAX_VALUE);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        targets[start] = 0;
        boolean[] visited = new boolean[n+1];
        // visited[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int i=1;i<=n;i++){
                if(i==cur) continue;
                if(prices[cur][i]==0) continue;
                if(targets[i]<=targets[cur]+prices[cur][i]) continue;
                if(visited[i]) continue;
                // visited[i] = true;
                queue.add(i);
                
                targets[i] = targets[cur]+prices[cur][i];
            }
        }
        for(int i=1;i<=n;i++){
            minimumPrices[start][i] = targets[i];
            minimumPrices[i][start] = targets[i];
        }
    }
}