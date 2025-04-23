
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MIN = 1;
    static int MAX = 100;
    static int[][] map;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                MIN = Math.min(MIN,map[i][j]);
                MAX = Math.max(MAX,map[i][j]);
            }
        }

        for(int i=MIN;i<=MAX;i++){  // 높이가 최소일때부터 최대일때까지 구하기
            int count = 0;
            int[][] currentMap = new int[N][N];
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(map[y][x]-i<=0)
                        currentMap[y][x] = 0;
                    else
                        currentMap[y][x] = 1;
                }
            }
            boolean[][] visit = new boolean[N][N];
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(currentMap[y][x]>0&&!visit[y][x]){
                        bfs(y,x,currentMap,visit);
                        count++;
                    }
                }
            }
            answer=Math.max(answer,count);
        }
        System.out.println(answer);
    }

    private static void bfs(int y, int x,int[][] map, boolean[][] visit) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y,x});
        visit[y][x] = true;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int[] dy = {-1,1,0,0};
            int[] dx = {0,0,-1,1};

            for(int d=0;d<4;d++){
                int ny = poll[0]+dy[d];
                int nx = poll[1]+dx[d];
                if(ny<0||nx<0||ny>N-1||nx>N-1||map[ny][nx]==0||visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(new int[]{ny,nx});
            }

        }
    }
}
