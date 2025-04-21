
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] board;
    static boolean[][] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = N*M;
        board = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            String[] split = br.readLine().split("");
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        visit[0][0] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int count = current[2];
            int y = current[0];
            int x = current[1];
            if(y ==N-1&& x ==M-1){
                answer = count;
                return;
            }

            int[] dy= {-1,1,0,0};
            int[] dx ={0,0,-1,1};
            for(int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny<0||nx<0||ny>=N||nx>=M||board[ny][nx]==0||visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(new int[]{ny,nx,count+1});
            }
        }
    }

}
