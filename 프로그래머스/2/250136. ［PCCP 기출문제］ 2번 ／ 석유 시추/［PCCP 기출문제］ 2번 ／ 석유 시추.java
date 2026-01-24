import java.util.*;

class Solution {
    int[] arr;
    boolean[][] visit;
    int[][] land;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int n,m;
    public int solution(int[][] land) {
        n = land[0].length;
        m = land.length;
        this.land = land;
        arr = new int[n];
        visit = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==0) continue;
                if(visit[i][j]) continue;
                check(i,j);
            }
        }
        
        Arrays.sort(arr);
        
        return arr[n-1];
    
    }
    
    private void check(int y,int x){
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        int total = 0;
        queue.add(new int[]{y,x});
        visit[y][x] = true;
        set.add(x);
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            total++;
            
            for(int d=0;d<4;d++){
                int ny = curY+dy[d];
                int nx = curX+dx[d];
                
                if(ny<0||nx<0||ny>=m||nx>=n) continue;
                if(land[ny][nx]==0)continue;
                if(visit[ny][nx]) continue;
                visit[ny][nx] = true;
                set.add(nx);
                queue.add(new int[]{ny,nx});
            }
            
         
        }
           for(int tx : set){
                // System.out.println(y+","+x+":"+total);
                arr[tx] += total;
            }
    }
}