import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int result = calculate(k, n);
            System.out.println(result);
        }
    }

    private static int calculate(int k, int n) {
        int[] before = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            before[i] = before[i - 1] + i;

        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                before[j] = before[j - 1] + before[j];
            }
        }

        return before[n] - before[n - 1];
    }

}
