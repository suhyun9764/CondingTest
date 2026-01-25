import java.util.*;

class Solution {
    int n;
    int answer = 0;
    int[] arr;
    boolean[] visit;
    public int solution(int n) {
        this.n = n;
        arr = new int[n];
        visit = new boolean[n];
        dfs(0);
        return answer;
    }
    
    private void dfs(int depth){
        if(depth==n){
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!isValid(depth,i)) continue;
            arr[depth] = i;
            visit[i] = true;
            dfs(depth+1);
            visit[i] = false;
        }
    }
    
    private boolean isValid(int depth,int c){
        if(visit[c]) return false;
        for(int i=0;i<depth;i++){
            if(Math.abs(depth-i)==Math.abs(c-arr[i])) return false;
        }
        
        return true;
    }
}