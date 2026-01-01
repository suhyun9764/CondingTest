import java.util.*;

class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    char[][] map;
    int startY,startX;
    int leverY,leverX;
    int l,w;
    public int solution(String[] maps) {
        // 시작점 -> 레버 찾기
        // 레버 -> 출구 찾기
        l = maps.length;
        w = maps[0].length();
        map = new char[l][w];
        
        for(int i=0;i<l;i++){
            String cur = maps[i];
            map[i] = cur.toCharArray();
            int sIndex = cur.indexOf('S');
            int lIndex = cur.indexOf('L');
            if(sIndex!=-1){
                startY = i;
                startX = sIndex;
            }
            if(lIndex!=-1){
                leverY = i;
                leverX = lIndex;
            }  
        }
        
        int sToL = findToLever();
        if(sToL==-1)
            return -1;
    
        int lToE = findToExit();
        if(lToE==-1)
            return -1;
        
        
        return sToL+lToE;
    }
    
    private int findToLever(){
        return bfs(startY,startX,'L');
    }
    
    private int findToExit(){
        return bfs(leverY,leverX,'E');
    }
    
    private int bfs(int y, int x, char target){
        boolean[][] visit = new boolean[l][w]; 
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x,0});
        visit[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            if(map[curY][curX]==target)
                return cur[2];
            
            for(int d=0;d<4;d++){
                int ny = curY+dy[d];
                int nx = curX+dx[d];
                
                if(ny<0||nx<0||ny>=l||nx>=w) continue;
                if(map[ny][nx]=='X') continue;
                if(visit[ny][nx]) continue;
                queue.add(new int[]{ny,nx,cur[2]+1});
                visit[ny][nx] = true;
            }
        }
        
        return -1;
    }
}