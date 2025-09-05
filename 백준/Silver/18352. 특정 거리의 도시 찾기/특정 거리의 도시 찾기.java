import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List[] list = new List[n+1];
        for(int i=1;i<=n;i++) list[i] = new ArrayList();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[x] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);

        while (!queue.isEmpty()){

            int cur = queue.poll();
            int curVal = dist[cur];
            List<Integer> neighbors = list[cur];

            for(int neighbor : neighbors) {
                if (dist[neighbor] > curVal + 1) {
                    dist[neighbor] = curVal + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==k){
                answer++;
                System.out.println(i);
            }
        }

        if(answer==0) System.out.println(-1);
    }
}
