import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visit[i][j]) {
                    visit[i][j] = true;
                    int total = dfs(i, j);
                    answerList.add(total);
                }
            }
        }

        Collections.sort(answerList);
        System.out.println(answerList.size());
        for(int answer : answerList){
            System.out.println(answer);
        }

    }

    private static int dfs(int i, int j) {
        int total = 1;

        for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];

            if(ny<0||nx<0||ny>=n||nx>=n||visit[ny][nx]) continue;
            if(map[ny][nx]=='1') {
                visit[ny][nx] = true;
                total += dfs(ny, nx);
            }
        }
        return total;
    }
}
