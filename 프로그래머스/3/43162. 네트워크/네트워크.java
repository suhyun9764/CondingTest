class Solution {
    boolean[] visit;
    int[][] computers;
    public int solution(int n, int[][] computers) {
        this.visit = new boolean[n];
        this.computers = computers;
        int answer = 0;
        for(int i=0;i<n;i++){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(i);
            answer++;
        }
        return answer;
    }
    
    private void dfs(int i){
        int[] nodes = computers[i];
        for(int node = 0; node<nodes.length;node++){
            if(node==i) continue;
            if(nodes[node]==0) continue;
            if(visit[node]) continue;
            visit[node] = true;
            dfs(node);
        }
    }
}