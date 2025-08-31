import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr=  new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1];
        int answer = 0;
        while (left<=right){
            int mid = (left+right)/2;
            if(isAvailable(arr,mid,m)){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isAvailable(int[] arr, int mid, int m) {
        int total = 0;
        for(int i : arr){
            if(i>=mid){
                total+=mid;
            }else{
                total+=i;
            }
        }

        return total <= m;
    }
}
