import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // O(nlog(n))
        int start = 1;
        int end = arr[arr.length-1]-arr[0];
        int ans =0;
        while(start<=end){
            int m = (start+end)/2;
            int num = getCount(arr,m);
            if(num<c){
                end = m-1;
            }else{
                ans = m;
                start = m+1;
            }
        }

        System.out.println(ans);
    }

    static int getCount(int[] arr, int m){
        int pastPoint = arr[0];
        int cnt =1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-pastPoint>=m){
                cnt++;
                pastPoint = arr[i];
            }
        }

        return cnt;
    }
}
