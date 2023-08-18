
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] originArr = new int[n+1];
        int[] sumArr = new int[n+1];
        int[][] commadns = new int[m][2];
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<n+1;i++){
            originArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1]+originArr[i];
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                commadns[i][j] = Integer.parseInt(st.nextToken());
            }
            int start = commadns[i][0];
            int end = commadns[i][1];

            int result = sumArr[end]-sumArr[start-1];
            bw.write(result+"\n");

        }

        bw.flush();





    }
}
