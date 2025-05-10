class Solution {
        public long solution(int n) {
            long[] dp = new long[n+1];
            if(n==1)
                return 1;
            if(n==2)
                return 2;
            
            makeDp(dp);
            return dp[n];
        }

        private void makeDp(long[] dp) {
            /*
            1,1,1,  1
            1,1,    2
            1,2,    1
            2,1,    1
            2,      2
             */
            dp[1] = 1;
            dp[2] = 2;
            if(dp.length>2){
                for(int i=3;i<dp.length;i++){
                    dp[i] = (dp[i-2]+dp[i-1])%1234567;
                }
            }
        }
    }