class Solution{
    
    public int solution(int[][] board){
        int h = board.length;
        int w = board[0].length;
        int max = 0;
        int[][] dp = new int[h][w];
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(board[i][j]!=1) continue;
                int left = 0;
                int up = 0;
                int leftUp = 0;
                if(j-1>=0) left = dp[i][j-1];
                if(i-1>=0) up = dp[i-1][j];
                if(i-1>=0&&j-1>=0) leftUp = dp[i-1][j-1];
                
                dp[i][j] = Math.min(left,Math.min(up,leftUp))+1;
                max = Math.max(dp[i][j],max);
            }
        }
        
        return max*max;
    }
}