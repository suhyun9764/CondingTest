import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start =0, end =0;
        int sum=arr[start];
        int length=n;
        int cnt =0;
        for(int i=0;i<n;i++){
            while (sum<s&&end<n-1){
                sum+=arr[++end];
            }

            if(sum>=s) {
                if (end - i + 1 < length) {
                    length = end - i + 1;
                }
                cnt++;

                sum -= arr[i];
            }
        }

        if(cnt==0)
            length=0;
        System.out.println(length);
    }
}
