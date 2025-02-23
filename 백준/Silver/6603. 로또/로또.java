import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int k;
    static int answer[] = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 주어진 집합에서 6가지 수 뽑기 -> 순서 상관x
            combine(0, 0);
            System.out.println();
        }

    }

    private static void combine(int now, int cnt) {
        if (cnt == 6) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if(now==k)
            return;

        answer[cnt] = arr[now];
        combine(now+1,cnt+1);
        answer[cnt] = 0;
        combine(now+1,cnt);
    }
}
