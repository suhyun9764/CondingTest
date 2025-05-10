import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        init();
        for(int i=1;i<N;i++){
            map[i][0] = Math.min(map[i-1][1],map[i-1][2])+map[i][0];
            map[i][1] = Math.min(map[i-1][0],map[i-1][2])+map[i][1];
            map[i][2] = Math.min(map[i-1][1],map[i-1][0])+map[i][2];
        }

        int answer = Arrays.stream(map[N - 1]).min().getAsInt();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
    }
}
