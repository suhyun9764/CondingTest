
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R;
    private static int C;

    private static char[][] map;
    private static boolean[] history = new boolean[26];
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        history[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int i, int j, int count) {
        max = Math.max(max, count);

        int[] x = {0, -1, 0, 1};
        int[] y = {-1, 0, 1, 0};

        for (int t = 0; t < 4; t++) {
            int a = i + y[t];
            int b = j + x[t];

            if (a >= 0 && a < R && b >= 0 && b < C) {
                if (!history[map[a][b] - 'A']) {
                    history[map[a][b] - 'A'] = true;
                    dfs(a, b, count + 1);
                    history[map[a][b] - 'A'] = false;
                }
            }
        }
    }
}
