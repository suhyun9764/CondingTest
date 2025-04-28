
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[N+1];
        dfs(0,list,visit);

    }

    private static void dfs(int count, List<Integer> list, boolean[] visit) {
        if(count==M){
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=N;i++){
            if(visit[i]) continue;
            visit[i] = true;
            list.add(i);
            dfs(count+1,list,visit);
            list.remove(list.size()-1);
            visit[i] = false;
        }

    }
}
