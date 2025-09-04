import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=n-1;i>=0;i--){

                int num = k/arr[i];
                answer+=num;
                k-=num*arr[i];


            if(k==0)
                break;
        }

        System.out.println(answer);
    }
}
