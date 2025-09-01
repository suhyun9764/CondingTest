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
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left =0;
        int right =0;

        int answer = arr[n-1]-arr[0];
        while(left<n&&right<n){
            int dif = arr[right] - arr[left];
            if(dif>=m){
                answer = Math.min(answer,dif);
                left++;
            }else{
                right++;
            }
        }

        System.out.println(answer);
    }
}
