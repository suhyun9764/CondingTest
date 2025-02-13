import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,V;
    static boolean[][] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        nodes = new boolean[N+1][N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[x][y] = true;
            nodes[y][x] = true;

        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v+" ");
        for(int i=0;i<N+1;i++){
            if(!visited[i]&&nodes[v][i])
                dfs(i);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visited[v] = true;


        while (!queue.isEmpty()){
            int currentV = queue.poll();
            System.out.print(currentV+" ");
            for(int i=0;i<N+1;i++){
                if(!visited[i]&&nodes[currentV][i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
