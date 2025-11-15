import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Route>[] routes = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            routes[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            routes[s].add(new Route(e,w));
        }

        int answer = 0;
        int[] backToHome = djst(X,routes);
        for(int i=1;i<=N;i++){
            if(i==X) continue;
            int[] djst = djst(i, routes);
            answer = Math.max(answer,djst[X]+backToHome[i]);

        }

        System.out.println(answer);
    }

    private static int[] djst(int i, List<Route>[] routes) {
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[i] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(i,0));

        while (!pq.isEmpty()){
            City city = pq.poll();
            int cur = city.v;

            if(visit[cur]) continue;
            visit[cur] = true;

            List<Route> curRoutes = routes[cur];
            for(Route route : curRoutes){
                if(dist[route.to]< city.dist+route.w) continue;
                dist[route.to] = city.dist + route.w;
                pq.add(new City(route.to,dist[route.to]));
            }
        }

        return dist;
    }

    public static class Route{
        int to;
        int w;

        public Route(int to, int w) {
            this.to = to;
            this.w = w;
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
            return dist-o.dist;
        }
    }
}


