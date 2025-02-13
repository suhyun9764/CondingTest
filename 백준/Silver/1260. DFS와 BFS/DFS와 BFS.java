import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visit = new boolean[N + 1];

        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);

    }

    static void dfs(int node) {
        visit[node] = true;
        sb.append(node).append(" ");

        for (Integer i : graph[node]) {
            if (!visit[i])
                dfs(i);
        }
    }

    static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (Integer i : graph[node]) {
                if (!visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
