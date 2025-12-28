import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] lengthMemo = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        lengthMemo[1] = 1;
        lengthMemo[2] = 1;
        lengthMemo[3] = 1;
        lengthMemo[4] = 2;
        lengthMemo[5] = 2;
        lengthMemo[6] = 3;
        for(int t=0;t<T;t++){
           int n = Integer.parseInt(br.readLine());
            System.out.println(getLength(n));
        }
    }

    private static long getLength(int n) {
        if(lengthMemo[n]!=0)
            return lengthMemo[n];

        return lengthMemo[n] = getLength(n-1)+getLength(n-5);
    }
}
