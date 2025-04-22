
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            String[] split = br.readLine().split("");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        Queue<Integer> answer = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if (map[i][j]==0||visit[i][j]) continue;
                answer.add(bfs(i,j));
            }
        }
        System.out.println(answer.size());
        while (!answer.isEmpty())
            System.out.println(answer.poll());


    }

    private static Integer bfs(int i, int j ) {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        visit[i][j] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            int[] dy = {-1,1,0,0};
            int[] dx = {0,0,-1,1};

            for(int d=0;d<4;d++){
                int ny = y+dy[d];
                int nx = x+dx[d];

                if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]==0||visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.offer(new int[]{ny,nx});
                count++;
            }
        }

        return count;
    }
}
