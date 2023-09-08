import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int end = 0;
        int value = arr[end]-arr[0];
        int min = arr[arr.length-1]-arr[0];
        for(int i=0;i<n;i++){
            while (arr[end]-arr[i]<m&&end<n-1){
                end++;
            }
            int diff = arr[end]-arr[i];
            if(diff>=m){
                if(diff<min)
                    min = diff;
            }
        }

        System.out.println(min);
    }
}
