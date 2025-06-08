import java.util.*;
class Solution {
    static int[][] maps;
    public int solution(int[][] maps) {
        this.maps = maps;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        return bfs(queue);
    }
    
    
    int bfs(Queue<int[]> queue){ 
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int count = current[2];
            
            if(y==maps.length-1&&x==maps[0].length-1)
                return count;
 
            int[] dy = {-1,1,0,0};
            int[] dx = {0,0,-1,1};
        
            for(int d=0;d<4;d++){
                int nY = y+dy[d];
                int nX = x+dx[d];
            
                if(nY<0||nY>=maps.length||nX<0||nX>=maps[0].length||visited[nY][nX]||maps[nY][nX]==0) continue;
                visited[nY][nX] = true;
                queue.add(new int[]{nY,nX,count+1});
            }
        }
        return -1;
    }
}