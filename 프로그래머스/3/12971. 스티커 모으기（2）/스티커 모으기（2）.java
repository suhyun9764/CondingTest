import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        
        if(n==1)
            return sticker[0];
        int[][] dp1 = new int[n-1][2];
        int[][] dp2 = new int[n-1][2];
        dp1[0][0] = 0;
        dp1[0][1] = sticker[0];
        dp2[0][0] = 0;
        dp2[0][1] = sticker[1];
        
        for(int i=1;i<n-1;i++){
            dp1[i][0] = Math.max(dp1[i-1][0],dp1[i-1][1]);
            dp1[i][1] = dp1[i-1][0]+sticker[i];
            
            dp2[i][0] = Math.max(dp2[i-1][0],dp2[i-1][1]);
            dp2[i][1] = dp2[i-1][0]+sticker[i+1];
        }
        
        int max1 = Math.max(dp1[n-2][0],dp1[n-2][1]);
        int max2 = Math.max(dp2[n-2][0],dp2[n-2][1]);
        
        return Math.max(max1,max2);
    }
}