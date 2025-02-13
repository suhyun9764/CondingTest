import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 상하좌우
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean isValid = true;
    static int max = -1;

    static int[][] container;
    static int N,M;

    // 방문 여부
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 가로
        N = Integer.parseInt(st.nextToken());   // 세로

        container = new int[N][M];
        visit = new boolean[N][M];

        List<int[]> already = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                int currentNum = Integer.parseInt(st.nextToken());
                if(currentNum==1)
                    already.add(new int[]{i,j});
                container[i][j] = currentNum;
            }
        }
        bfs(already);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(container[i][j]==0)
                    isValid=false;
                if(container[i][j]>max)
                    max = container[i][j];
            }
            if (!isValid)
                break;
        }
        if(!isValid) {
            System.out.println(-1);
            return;
        }

        System.out.println(max-1);
    }

    private static void bfs(List<int[]> already) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] position : already) {
            queue.offer(position);
            visit[position[0]][position[1]] = true;
        }

        while (!queue.isEmpty()){
            int[] currentPosition = queue.poll();
            int y = currentPosition[0];
            int x = currentPosition[1];
            visit[y][x] =true;

            for(int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];

                if(ny<0||nx<0||ny>=N||nx>=M||container[ny][nx]==1||container[ny][nx]==-1||visit[ny][nx]) continue;
                container[ny][nx] = container[y][x]+1;
                visit[ny][nx] = true;
                queue.offer(new int[]{ny,nx});
            }
        }
    }

}
