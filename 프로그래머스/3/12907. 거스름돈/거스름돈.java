import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        Arrays.sort(money);
        dp[0] = 1;
        
        for(int i=0;i<money.length;i++){
            int coin = money[i];
            for(int j=coin;j<=n;j++){
                dp[j] += dp[j-coin]%1000000007;
            }
        }
        
        return dp[n];
    }
}