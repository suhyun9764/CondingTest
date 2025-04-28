
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

        int[] arr = new int[M];
        StringBuilder sb = new StringBuilder();
        dfs(0,arr,sb);
        System.out.println(sb.toString());

    }

    private static void dfs(int count, int[] arr,StringBuilder sb) {
        if(count==M){
            for (Integer i : arr) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            arr[count] = i;
            dfs(count+1,arr,sb);
        }

    }
}
