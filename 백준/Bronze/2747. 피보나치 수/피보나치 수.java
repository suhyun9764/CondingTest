import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(getFibo(n));
    }

    private static long getFibo(int n) {
        if(n==1)
            return 1 ;

        long[] memo = new long[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i=2;i<=n;i++){
            memo[i] = memo[i-2]+memo[i-1];
        }

        return memo[n];
    }
}
