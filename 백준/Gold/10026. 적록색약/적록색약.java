
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }
        look();
        changeMap();    // 색약 모드로 변경
        look();    
    }

    private static void look() {
        boolean[][] visit = new boolean[N][N];
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[i][j]) continue;
                bfs(i,j,visit);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(int y, int x, boolean[][] visit) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visit[y][x] = true;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            char currentColor = map[poll[0]][poll[1]];
            int[] dy = {-1,1,0,0};
            int[] dx = {0,0,-1,1};
            for(int d=0;d<4;d++){
                int ny = poll[0]+dy[d];
                int nx = poll[1]+dx[d];
                if(ny<0||nx<0||ny>=N||nx>=N||visit[ny][nx]||map[ny][nx]!=currentColor) continue;
                visit[ny][nx] = true;
                queue.offer(new int[]{ny,nx});
            }
        }
    }


    private static void changeMap() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int currentColor = map[i][j];
                if(currentColor=='G')
                    map[i][j] = 'R';
            }
        }
    }

}
