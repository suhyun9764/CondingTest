
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            boolean[][] visit = new boolean[N][N];  // 하루가 지날때마다 방문 배열 초기화
            boolean move = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문하지 않았다면 바로 bfs
                    if (visit[i][j]) continue;
                    if(bfs(i, j, visit))
                        move =true;
                }
            }

            if (move == false)
                break;

            answer++;
        }
        System.out.println(answer);
    }

    private static boolean bfs(int y, int x, boolean[][] visit) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        List<int[]> association = new ArrayList<>();
        association.add(new int[]{y, x});
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            sum += map[poll[0]][poll[1]];
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};
            for (int d = 0; d < 4; d++) {
                int ny = poll[0] + dy[d];
                int nx = poll[1] + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
                int abs = Math.abs(map[ny][nx] - map[poll[0]][poll[1]]);
                if (abs >= L && abs <= R) {
                    visit[ny][nx] = true;
                    association.add(new int[]{ny, nx});
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        if (association.size() == 1)
            return false;

        int avg = sum / association.size();
        for (int[] country : association) {
            map[country[0]][country[1]] = avg;
        }
        return true;
    }
}