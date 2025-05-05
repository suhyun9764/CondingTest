
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int zeroCnt,oneCnt;
    static int[][] memo = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeMemo();
        T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            zeroCnt = 0;
            oneCnt = 0;
            int n = Integer.parseInt(br.readLine());
            System.out.println(memo[n][0]+" "+memo[n][1]);
        }
    }

    private static void makeMemo() {
        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for(int i=2;i<=40;i++){
            memo[i][0] = memo[i-1][0]+memo[i-2][0];
            memo[i][1] = memo[i-1][1]+memo[i-2][1];
        }
    }
}
