import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, maxLength;
    static int[] arr,dp;

    public static void main(String[] args) throws IOException {
        init();
        maxLength = 0;

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }

        int asInt = Arrays.stream(dp).max().getAsInt();
        System.out.println(asInt);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}