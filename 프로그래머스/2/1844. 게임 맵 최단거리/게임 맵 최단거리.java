import java.util.*;

class Solution {
    boolean[][] visit;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(0,0,1));
        int answer = -1;
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            if(cur.y==n-1&&cur.x==m-1) {
                answer = cur.order;
                break;
            }
            
            for(int d=0;d<4;d++){
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                if(ny<0||ny>=n||nx<0||nx>=m) continue;
                if(visit[ny][nx]) continue;
                if(maps[ny][nx]==0) continue;
                visit[ny][nx] = true;
                queue.add(new Pos(ny,nx,cur.order+1));
            }
        }
        
        return answer;
    }
}

class Pos{
    int y;
    int x;
    int order;
    
    public Pos(int y,int x, int order){
        this.y = y;
        this.x = x;
        this.order = order;
    }
}