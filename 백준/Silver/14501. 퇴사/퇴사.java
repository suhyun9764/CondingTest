import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] needDays = new int[n + 1];
        int[] income = new int[n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            needDays[i] = Integer.parseInt(st.nextToken());
            income[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(needDays));
//        System.out.println(Arrays.toString(income));

        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            if (i + needDays[i] <= n + 1)
                dp[i + needDays[i]] = Math.max(dp[i + needDays[i]], dp[i] + income[i]);

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n+1]);
    }
}
