class Solution {
    int answer = 0;
    int[][] stDungeons;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        stDungeons = dungeons;
        visit = new boolean[dungeons.length];
        dfs(k,0);
        return answer;
    }
    
    void dfs(int k, int total){
        answer = Math.max(answer,total);
        
        for(int i=0;i<visit.length;i++){
            if(!visit[i] && k>=stDungeons[i][0]){
                visit[i] = true;
                dfs(k-stDungeons[i][1],total+1);
                visit[i] = false;
            }
        }
    }
}