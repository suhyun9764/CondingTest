import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] xorArr = new int[n+1];
        st= new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            xorArr[i] = xorArr[i-1]^arr[i];
        }
        int[] resultArr = new int[q];
        int result=0;
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result = result^(xorArr[end]^xorArr[start-1]);
        }

        System.out.println(result);


    }
}
