import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(n,0));
        dist[n] = 0;

        while(!pq.isEmpty()){
            Pos cur = pq.poll();
            int curPos = cur.pos;

            if(curPos==k){
                System.out.println(cur.order);
                break;
            }

            if(curPos+1<=100000&&dist[curPos+1]>cur.order+1) {
                pq.add(new Pos(curPos+1,cur.order+1));
                dist[curPos+1] = cur.order+1;
            }
            if(curPos-1>=0&&dist[curPos-1]>cur.order+1) {
                pq.add(new Pos(curPos-1,cur.order+1));
                dist[curPos-1] = cur.order+1;
            }
            if(curPos*2<=100000&&dist[curPos*2]>cur.order) {
                pq.add(new Pos(curPos*2,cur.order));
                dist[curPos*2] = cur.order;
            }
        }
    }

    private static class Pos implements Comparable<Pos>{
        int pos;
        int order;

        public Pos(int pos, int order) {
            this.pos = pos;
            this.order = order;
        }

        public int compareTo(Pos o){
            return this.order-o.order;
        }
    }
}
