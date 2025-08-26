import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            if (curY == N - 1 && curX == M - 1) {
                System.out.println(map[curY][curX]);
                break;
            }

            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            for (int d = 0; d < 4; d++) {
                int ny = curY + dy[d];
                int nx = curX + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] != 1) continue;
                map[ny][nx] = map[curY][curX] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}
