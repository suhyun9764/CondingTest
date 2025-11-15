import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Edge>[] edges;
    static int N,M,A,B;
    public static void main(String[] args) throws IOException {
        // 1 -> A ->B ->N
        // 1 -> B ->A ->N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[s].add(new Edge(e,w));
            edges[e].add(new Edge(s,w));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[] dist1 = dist(1);
        int[] distA = dist(A);
        int[] distB = dist(B);

        int sToA = dist1[A];
        int sToB = dist1[B];
        int aToN = distA[N];
        int aToB = distA[B];
        int bToN = distB[N];
        int bToA = distB[A];

        int c1 = sToA+aToB+bToN;
        int c2 = sToB+bToA+aToN;

        int answer;
        if(sToA==Integer.MAX_VALUE||aToB==Integer.MAX_VALUE||bToN==Integer.MAX_VALUE){
            c1 = Integer.MAX_VALUE;
        }

        if(sToB==Integer.MAX_VALUE||bToA==Integer.MAX_VALUE||aToN==Integer.MAX_VALUE){
            c2 = Integer.MAX_VALUE;
        }
        
        answer = Math.min(c1,c2);
        if(answer==Integer.MAX_VALUE) answer = -1;
        
        System.out.println(answer);

    }

    private static int[] dist(int i) {
        int[] dist = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(i,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[i] = 0;
        boolean[] visit = new boolean[N+1];
        while (!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.v;
            if(visit[cur]) continue;
            visit[cur] = true;

            List<Edge> curEdges = edges[cur];
            for(Edge edge : curEdges){
                if(dist[edge.to]<=node.dist+edge.cost) continue;
                dist[edge.to] = node.dist+edge.cost;
                pq.add(new Node(edge.to,dist[edge.to]));
            }
        }

        return dist;
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        public int compareTo(Node o){
            return dist-o.dist;
        }
    }
}
