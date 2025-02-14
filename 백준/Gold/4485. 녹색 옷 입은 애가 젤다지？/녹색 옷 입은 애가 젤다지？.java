import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] cave;
    static int[][] cost;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int INF = Integer.MAX_VALUE;
    static int problemNum = 1;
    static int N;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            findMinimumDamage(N, br);
            problemNum++;
        }

    }

//    private static void findMinimumDamage(int N, BufferedReader br) throws IOException {
//        cave = new int[N][N];
//        cost = new int[N][N];
//        StringTokenizer st;
//        for(int i = 0; i< N; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j< N; j++){
//                cave[i][j] = Integer.parseInt(st.nextToken());
//            }
//            Arrays.fill(cost[i],INF);
//        }
//
//        PriorityQueue<Vertex> queue = new PriorityQueue<>(new Comparator<Vertex>() {
//            @Override
//            public int compare(Vertex o1, Vertex o2) {
//                return o1.c-o2.c;
//            }
//        });
//        queue.offer(new Vertex(0,0,cave[0][0]));
//        while (!queue.isEmpty()){
//            Vertex vertex = queue.poll();
//            int y = vertex.vY;
//            int x = vertex.vX;
//            cost[y][x] = vertex.c;
//
//            for(int i=0;i<4;i++){
//                int nY = y+dy[i];
//                int nX = x+dx[i];
//                if(nY<0||nX<0||nY>= N ||nX>= N)continue;
//                if(cost[nY][nX]>vertex.c+cave[nY][nX]){
//                    cost[nY][nX] = vertex.c+cave[nY][nX];
//                    queue.offer(new Vertex(nY,nX,cost[nY][nX]));
//                }
//            }
//        }
//
//        System.out.println("Problem "+problemNum+": "+cost[N -1][N -1]);
//    }


    // visit 이용
    private static void findMinimumDamage(int N, BufferedReader br) throws IOException {
        cave = new int[N][N];
        cost = new int[N][N];
        visit = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cave[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(cost[i], INF);
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.c - o2.c;
            }
        });
        queue.offer(new Vertex(0, 0, cave[0][0]));
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (visit[vertex.vY][vertex.vX]) continue;
            visit[vertex.vY][vertex.vX] = true;
            int y = vertex.vY;
            int x = vertex.vX;
            cost[y][x] = vertex.c;

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];
                if (nY < 0 || nX < 0 || nY >= N || nX >= N) continue;
                if (cost[nY][nX] > vertex.c + cave[nY][nX]) {
                    cost[nY][nX] = vertex.c + cave[nY][nX];
                    queue.offer(new Vertex(nY, nX, cost[nY][nX]));
                }
            }
        }

        System.out.println("Problem " + problemNum + ": " + cost[N - 1][N - 1]);
    }

    static class Vertex {
        int vY;
        int vX;
        int c;

        public Vertex(int vY, int vX, int c) {
            this.vY = vY;
            this.vX = vX;
            this.c = c;
        }
    }
}
