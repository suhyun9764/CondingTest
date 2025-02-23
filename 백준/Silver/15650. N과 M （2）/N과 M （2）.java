
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] result = new int[M];
        dfs(0, result,1);

    }

    private static void dfs(int count, int[] result,int start) {
        if (count == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if(start>N)
            return;

        result[count] =start;
        dfs(count+1,result,start+1);
        result[count] = 0;
        dfs(count,result,start+1);

    }

}
