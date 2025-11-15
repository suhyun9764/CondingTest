import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 도시는 정점, 버스는 간선

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        List<Bus>[] buses = new ArrayList[N+1];
        for(int i=0;i<buses.length;i++){
            buses[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            buses[s].add(new Bus(e,w));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(S,0));

        boolean[] visit = new boolean[N+1];
        while (!pq.isEmpty()){
            City city = pq.poll();
            int cur = city.v;

            if(visit[cur]) continue;
            visit[cur] = true;

            List<Bus> curBuses = buses[cur];
            for(Bus bus : curBuses){
                if(dist[bus.to]< city.dist + bus.cost) continue;
                dist[bus.to] = city.dist + bus.cost;
                pq.add(new City(bus.to,dist[bus.to]));
            }
        }

        System.out.println(dist[E]);


    }

    public static class Bus{
        int to;
        int cost;

        public Bus(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class City implements Comparable<City>{
        int v;
        int dist;

        public City(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        public int compareTo(City o){
            return this.dist - o.dist;
        }
    }
}
