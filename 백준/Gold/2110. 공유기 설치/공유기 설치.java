import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left =0;
        int right = arr[arr.length-1]-arr[0];
        int answer = 0;
        while (left<=right){
             int mid = (left+right)/2;
             if(isAvailable(arr,mid,c)){
                 left = mid+1;
                 answer = mid;
             }else{
                 right = mid-1;
             }
        }

        System.out.println(answer);


    }

    private static boolean isAvailable(int[] arr, int mid,int c) {
        int before = arr[0];
        int cnt = 1;
        for(int i=1;i<arr.length;i++){
            int cur = arr[i];
            if(cur-before>=mid){
                cnt++;
                before = cur;
            }
        }

        if(cnt >= c){
            return true;
        }

        return false;
    }
}
