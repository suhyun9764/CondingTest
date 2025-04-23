
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T,V,E;
    static ArrayList<Integer>[] nodes;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            nodes = new ArrayList[V+1];
            for(int j=0;j<V+1;j++){
                nodes[j] = new ArrayList<>();
            }
            answer = "YES";
            for(int j=0;j<E;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                nodes[a].add(b);
                nodes[b].add(a);

            }
            int[] color = new int[V+1];
            Arrays.fill(color,0);
            color[0] = -1;
            for(int d=1;d<V+1;d++){
                if(color[d]==0)
                    dfs(d,0,color);
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int node, int parent,int[] color) {
        color[node] = color[parent]*-1;
        for (Integer child : nodes[node]) {
            if(child==parent) continue;
            if(color[child]==color[node]){
                answer = "NO";
                return;
            }
            if(color[child]==0)
                dfs(child,node,color);
        }
    }
}
