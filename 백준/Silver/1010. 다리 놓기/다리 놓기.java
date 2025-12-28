import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            calculate(n,m);
            System.out.println(dp[m][n]);
        }
    }

    private static int calculate(int n, int m) {
        if(dp[m][n]!=0)
            return dp[m][n];

        if(n==m||n==0)
            return dp[m][n] = 1;

        dp[m][n] = calculate(n-1,m-1)+calculate(n,m-1);
        return dp[m][n];
    }
}
