
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer>[] nodes;
    private static StringTokenizer st;
    private static Boolean[] visit;
    private static int cnt;
    private static int num=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            settingNandM(br);
            if(N==0&&M==0)
                break;
            settingNodes(br);

            for(int i=1;i<N+1;i++){
                if(visit[i]==true)
                    continue;
                if(dfs(i,-1)) cnt++;
            }

            System.out.print("Case "+num++ +": ");
            if(cnt==0){
                System.out.println("No trees.");
            }else if(cnt==1){
                System.out.println("There is one tree.");
            }else{
                System.out.println("A forest of "+cnt+" trees.");
            }

        }
    }

    private static boolean dfs(int root, int parent) {
        visit[root] = true;

        for (Integer child : nodes[root]) {
            if(visit[child]){
                if(child!=parent)
                    return false;
            }else{
                if(!dfs(child,root))
                    return false;
            }
        }

        return true;
    }


    private static void settingNandM(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    private static void settingNodes(BufferedReader br) throws IOException {
        nodes = new List[N+1];
        visit = new Boolean[N+1];
        Arrays.fill(visit,false);
        for(int i=1;i<N+1;i++){
            nodes[i] = new ArrayList<>();
        }
        cnt = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
    }

}
