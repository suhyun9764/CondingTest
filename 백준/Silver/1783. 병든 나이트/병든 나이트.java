import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 2) {
            getAnswerIf2(m);
        }

        if (n > 2) {
            getAnswerIfOver2(m);
        }

        System.out.println(ans);
    }

    private static void getAnswerIfOver2(int m) {
        if (m < 7) {
            int movable = Math.min(3, m-1);
            ans += movable;
            return;
        }
        ans += m - 3;
    }

    private static void getAnswerIf2(int m) {
        int moveAble = (m - 1) / 2;
        if (moveAble >= 3) {
            ans += 3;
            return;
        }
        ans += moveAble;
    }
}
