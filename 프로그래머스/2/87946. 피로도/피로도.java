class Solution {
    static int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        boolean visit[] = new boolean[dungeons.length];
        return dfs(k,visit,0);
    }
    
    int dfs(int k, boolean[] visit, int depth){
        int max = depth;
        for(int i=0;i<dungeons.length;i++){
            if(visit[i]) continue;
            int minTired = dungeons[i][0];
            if(k<minTired) continue;
            int consumeTired = dungeons[i][1];
            visit[i] = true;
            max = Math.max(max,dfs(k-consumeTired,visit,depth+1));
            visit[i] = false;
        }
        return max;
    }
}