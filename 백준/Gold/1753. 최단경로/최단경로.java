import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int coast = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,coast));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.idx]<cur.coast) continue;

            for(Node next : graph.get(cur.idx)){
                if(dist[next.idx]<cur.coast+ next.coast) continue;
                dist[next.idx] = Math.min(dist[next.idx],cur.coast+ next.coast);
                pq.add(new Node(next.idx,dist[next.idx]));
            }
        }

        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }

    }

    private static class Node implements Comparable<Node>{
        int idx;
        int coast;

        public Node(int idx, int coast) {
            this.idx = idx;
            this.coast = coast;
        }

        public int compareTo(Node o){
            return this.coast-o.coast;
        }
    }
}

