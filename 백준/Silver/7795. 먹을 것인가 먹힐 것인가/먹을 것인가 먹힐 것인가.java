import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) { // 각 테스트 마다
            st = new StringTokenizer(br.readLine());
            int[] aArr = new int[Integer.parseInt(st.nextToken())];
            int[] bArr = new int[Integer.parseInt(st.nextToken())];
            int pairNum = 0;
            st = new StringTokenizer(br.readLine());
            for (int a = 0; a < aArr.length; a++) {
                aArr[a] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < bArr.length; b++) {
                bArr[b] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(aArr);
            Arrays.sort(bArr);

            for (int j = 0; j < aArr.length; j++) {
                int start = 0;
                int end = bArr.length - 1;
                boolean smallCheck = false;
                int bufM = 0;
                while (start <= end) {
                    int m = (start + end) / 2;
                    if (aArr[j] > bArr[m]) {
                        smallCheck = true;
                        start = m + 1;
                        bufM = m;
                    } else end = end - 1;
                }
                if (smallCheck)
                    pairNum = pairNum + bufM + 1;
            }
            System.out.println(pairNum);
        }


    }
}
