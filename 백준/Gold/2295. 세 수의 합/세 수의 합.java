import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] sum = new int[n*(n+1)/2];
        int index =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum[index++] = arr[i]+arr[j];
            }
        }
        Arrays.sort(sum);
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int target = arr[i]-arr[j];
                if(haveValue(sum,target))
                ans = Math.max(ans,arr[i]);
            }
        }
        
        System.out.println(ans);
    }

    private static boolean haveValue(int[] sum, int target) {
        int start =0;
        int end = sum.length-1;
        while(start<=end){
            int m = (start+end)/2;
            if(sum[m]<target) start = m+1;
            else if(sum[m]>target) end = m-1;
            else return true;
        }
        return false;
    }

}
