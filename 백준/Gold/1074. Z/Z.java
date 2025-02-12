import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);
        z(0, 0);

        System.out.println(ans);

    }

    private static void z(int y, int x) {
        if(N==1)
            return;
        N /= 2;
        if (r < y + N && c < x + N) {   // 좌상
            z(y,x);
        } else if (r < y + N && c >= x + N) {//우상
            ans+=N*N*1;
            x+=N;
            z(y,x);
        } else if (r>=y+N && c < x + N){
            ans+=N*N*2;
            y+=N;
            z(y,x);
        } else{
            ans+=N*N*3;
            x+=N;
            y+=N;
            z(y,x);
        }
    }
}
