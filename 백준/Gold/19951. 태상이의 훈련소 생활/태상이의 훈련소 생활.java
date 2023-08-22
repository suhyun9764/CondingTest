import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ground = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){  // N<10000
            ground[i] =Integer.parseInt(st.nextToken());
        }

        int[] delta = new int[n+2];
        for(int i=0;i<m;i++){ // M<10000
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()); //end <10000
            int val = Integer.parseInt(st.nextToken());

            delta[start] += val;
            delta[end+1] -= val;
        }
        int[] accDelta = new int[n+1];
        for(int i=1;i<n+1;i++){
            accDelta[i] = accDelta[i-1]+delta[i];
            bw.write(ground[i]+accDelta[i]+" ");
        }
        bw.flush();

    }
}
