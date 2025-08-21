import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp,-1);
        
        dp[x] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current==y)
                return dp[current];
            
            int[] nexts = {current+n, current*2, current*3};
            for(int i=0;i<nexts.length;i++){
                if(nexts[i]<=y&&dp[nexts[i]]==-1){
                    queue.add(nexts[i]);
                    dp[nexts[i]] = dp[current]+1;
                }
            }
        }
        
        return -1;
    }
}