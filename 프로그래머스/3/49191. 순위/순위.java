import java.util.*;


class Solution {
     Set<Integer>[] uppers;
     Set<Integer>[] unders;
    public int solution(int n, int[][] results) {
        uppers = new Set[n+1];
        unders = new Set[n+1];
        
        for(int i=1;i<=n;i++){
            uppers[i] = new HashSet<>();
            unders[i] = new HashSet<>();
        }
        
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            
            uppers[loser].add(winner);
            unders[winner].add(loser);
        }
        
        int answer = 0;
        for(int i=1;i<=n;i++){
            int upCnt = dfsUp(i,new boolean[n+1])-1;
            int downCnt = dfsDown(i,new boolean[n+1])-1;
            if(upCnt+downCnt==n-1) answer++;
        }
        
        return answer;

    }
    
    private int dfsUp(int i, boolean[] visit){
        Set<Integer> cur = uppers[i];
        int total = 1;
        for(int win : cur){
            if(visit[win]) continue;
            visit[win] = true;
            total += dfsUp(win,visit);
        }
        
        return total;
    }
    
        private int dfsDown(int i, boolean[] visit){
        Set<Integer> cur = unders[i];
        int total = 1;
        for(int loser : cur){
            if(visit[loser]) continue;
            visit[loser] = true;
            total += dfsDown(loser,visit);
        }
        
        return total;
    }
}