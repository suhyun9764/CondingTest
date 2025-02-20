
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] zero;
    static int[][] virus;
    static int wallNumber = 0;
    static int answer = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        setting();
        simulation();
//        combine(0,0);
        System.out.println(answer);
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int zeroCnt = 0;
        int virusCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    zeroCnt++;
                else if (map[i][j] == 2)
                    virusCnt++;
                else {
                    wallNumber++;
                }
            }
        }

        zero = new int[zeroCnt][2];
        int tempCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    zero[tempCnt++] = new int[]{i, j};
            }
        }


        virus = new int[virusCnt][2];
        tempCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2)
                    virus[tempCnt++] = new int[]{i, j};
            }
        }
    }
    private static void simulation() {
        for (int i = 0; i < zero.length - 2; i++) {
            int[] firstWall = zero[i];
            map[firstWall[0]][firstWall[1]] = 1;
            for (int j = i + 1; j < zero.length - 1; j++) {
                int[] secondWall = zero[j];
                map[secondWall[0]][secondWall[1]] = 1;
                for (int k = j + 1; k < zero.length; k++) {
                    // 1. 세개의 벽 세우기
                    int[] thirdWall = zero[k];
                    map[thirdWall[0]][thirdWall[1]] = 1;
                    // 2. 바이러스 퍼뜨리기
                    int virusResult = startVirus();
                    // 3. 0인 공간 갯수 찾고 업데이트
                    getEachResult(virusResult);
                    map[thirdWall[0]][thirdWall[1]] = 0;
                }
                map[secondWall[0]][secondWall[1]] = 0;
            }
            map[firstWall[0]][firstWall[1]] = 0;
        }
    }

    private static void combine(int srcIdx, int idxNum) {
        if(idxNum==3){
            int virusResult = startVirus();
            getEachResult(virusResult);
        }

        if(srcIdx == zero.length) return;
        
    }

    private static void getEachResult(int virusResult) {
        int safetyZone = (N * M) - wallNumber - virusResult - 3;
        answer = Math.max(answer, safetyZone);
    }

    private static int startVirus() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempMap[i] = Arrays.copyOf(map[i], M);
        }
        int totalVirus = 0;
        for (int i = 0; i < virus.length; i++) {
            int[] currentVirus = virus[i];
//            totalVirus += bfs(currentVirus, tempMap);
            totalVirus += dfs(currentVirus,tempMap,0);
        }

        return totalVirus;
    }

    private static int dfs(int[] virus, int[][] tempMap, int cnt) {
        int totalNum = 1;
        for (int d = 0; d < 4; d++) {
            int ny = virus[0] + dy[d];
            int nx = virus[1] + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || tempMap[ny][nx] != 0) continue;
            tempMap[ny][nx] = 2;
            totalNum+= dfs(new int[]{ny,nx},tempMap,cnt);
        }
        return totalNum;
    }

    private static int bfs(int[] initVirus, int[][] tempMap) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(initVirus);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            cnt++;
            for (int d = 0; d < 4; d++) {
                int ny = virus[0] + dy[d];
                int nx = virus[1] + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || tempMap[ny][nx] != 0) continue;
                tempMap[ny][nx] = 2;
                queue.offer(new int[]{ny, nx});
            }
        }
        return cnt;
    }

}

