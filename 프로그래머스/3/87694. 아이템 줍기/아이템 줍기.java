import java.util.*;

class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];
        boolean[][] visit = new boolean[102][102];
        
        // 전체 다 1로 채우기
        for(int[] rec : rectangle){
            int lx = 2*rec[0];
            int ly = 2*rec[1];
            int rx = 2*rec[2];
            int ry = 2*rec[3];
            
            for(int i=ly;i<=ry;i++){
                for(int j=lx;j<=rx;j++){
                    // System.out.println("y : "+i + "\nx : "+j);
                    map[i][j] = 1;
                }
                // System.out.println(Arrays.toString(map[ly]));
                // System.out.println();
            }
        }
        
        // 내부는 0으로 채우기
        for(int[] rec : rectangle){
            int lx = 2*rec[0];
            int ly = 2*rec[1];
            int rx = 2*rec[2];
            int ry = 2*rec[3];
            
            for(int i=ly+1;i<ry;i++){
                for(int j=lx+1;j<rx;j++){
                    map[i][j] = 0;
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{2*characterY,2*characterX,0});
        visit[2*characterY][2*characterX] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            // System.out.println(Arrays.toString(cur));
            if(cur[0]==2*itemY&&cur[1]==2*itemX) return cur[2]/2;
            
            for(int d=0;d<4;d++){
                int ny = cur[0]+dy[d];
                int nx = cur[1]+dx[d];
                if(ny<0||ny>=102||nx<0||nx>=102) continue;
                if(map[ny][nx]==0) continue;
                // System.out.println("map pass");
                if(visit[ny][nx]) continue;
                
                visit[ny][nx] = true;
                queue.add(new int[]{ny,nx,cur[2]+1});
            }
            

        }
        return 0;
    }
}