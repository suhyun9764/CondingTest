import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static Edge[] edges;
    static int sum = 0;
    static int cnt = 0;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v1, v2, c);
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.c - o2.c;
            }
        });

        makeSet();

        for(int i=0;i<E;i++){
            Edge edge = edges[i];
            if(union(edge.v1,edge.v2)){
                sum+=edge.c;
                cnt++;
            }
            if (cnt==V-1)
                break;
        }

        System.out.println(sum);
    }

    static class Edge {
        int v1;
        int v2;
        int c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }


    private static void makeSet() {
        for(int i=1;i<V+1;i++){
            parent[i] = i;
        }
    }

    private static int findSet(int v){
        if(parent[v]==v) return v;
        return parent[v] = findSet(parent[v]);
    }

    private static boolean union(int v1, int v2){
        int v1p = findSet(v1);
        int v2p = findSet(v2);

        if(v1p==v2p) return false;
        if(v1p<v2p) {
            parent[v2p]=v1p;
        }else{
            parent[v1p] = v2p;
        }
        return true;
    }
}
