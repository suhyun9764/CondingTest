import java.util.*;

class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int h,w;
    String[] board;
    public int solution(String[] board) {
        // bfs
        // d거나 길이 끝까지가면 스탑 
        // 상하좌우 탐색
        h = board.length;
        w = board[0].length();
        this.board = board;
        
        int sY = 0;
        int sX = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
              if(board[i].charAt(j)=='R'){
                  sY = i;
                  sX = j;
              }
            }
        }
        
        boolean[][] visit = new boolean[h][w];
        visit[sY][sX] = true;
        Queue<int[]> queue= new ArrayDeque<>();
        queue.add(new int[]{sY,sX,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int cost = cur[2];
            
            if(board[curY].charAt(curX)=='G') return cost;
            
            for(int d=0;d<4;d++){
                int[] next = goToEnd(curY,curX,d);
                int ny = next[0];
                int nx = next[1];
                if(visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(new int[]{ny,nx,cost+1});
            }
        }
        
        return -1;
        
    }
    
    private int[] goToEnd(int y,int x,int d){
        int nY = y+dy[d];
        int nX = x+dx[d];
        while(true){
            if(nY<0||nX<0||nY>=h||nX>=w) break;
            if(board[nY].charAt(nX)!='.'&& board[nY].charAt(nX)!='R'&&board[nY].charAt(nX)!='G') break;
            y = nY;
            x = nX;
            nY += dy[d];
            nX += dx[d];
        }
        
        return new int[]{y,x};
    }
}