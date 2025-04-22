
import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[][] network;
    private static boolean[] visited;
    private static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        network = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a][b] = 1;
            network[b][a] = 1;
        }

        dfs(1);

        System.out.println(answer);


    }

    private static void dfs(int v) {
        visited[v] = true;
        answer++;

        for(int i=1;i<N+1;i++){
            if(network[v][i]==1&&visited[i]==false){
                dfs(i);
            }
        }
    }
}
