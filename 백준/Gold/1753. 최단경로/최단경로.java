import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Edge{
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static class Node implements Comparable<Node>{
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        public int compareTo(Node o){
            return this.dist-o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        List<Edge>[] edges = new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[start].add(new Edge(end,w));
        }


        boolean[] visit = new boolean[v + 1];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(k,0));
        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.v;
            if(visit[cur]) continue;
            visit[cur] = true;
            List<Edge> edgeList = edges[cur];

            for(Edge edge : edgeList){
                if(dist[edge.to]<node.dist+edge.w) continue;
                dist[edge.to] = node.dist+edge.w;
                queue.add(new Node(edge.to,dist[edge.to]));
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }
}