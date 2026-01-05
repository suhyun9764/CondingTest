import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[][][] visit;
    int[][] board;
    int n;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    public int solution(int[][] board) {
        n = board.length;
        this.board = board;
        visit = new boolean[n][n][4];
        for(int i=0;i<4;i++){
            visit[0][0][i] = true;
        }
 
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.add(new int[]{0,0,0,0});
      
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int y = cur[0];
            int x = cur[1];
            int total = cur[2];
            int beforeD = cur[3];
    
            if(y==n-1&&x==n-1)
                return total;
            
            visit[y][x][beforeD] = true;
            
            for(int d=0;d<4;d++){
                int ny = y+dy[d];
                int nx = x+dx[d];
                
                if(ny<0||nx<0||ny>=n||nx>=n) continue;
                if(board[ny][nx]==1) continue;
                if(visit[ny][nx][d]) continue;
                
                int cost = 100;
                if(!(x==0&&y==0)&&beforeD!=d){
                    cost+=500;
                }
                queue.add(new int[]{ny,nx,total+cost,d});
            }
            
        }
        
        return 0;
    }
}