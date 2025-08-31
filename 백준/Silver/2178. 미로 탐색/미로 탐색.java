import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = charArray[j] - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            if (y == n - 1 && x == m - 1) {
                answer = map[y][x];
                break;
            }
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] != 1) continue;
                map[ny][nx] = map[y][x] + 1;
                queue.add(new int[]{ny, nx});
            }
        }

        System.out.println(answer);
    }
}
