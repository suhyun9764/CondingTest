import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start =0;
        int end = arr[arr.length-1];
        int ans =0;
        while(start<=end){
            int mid = (start+end)/2;
            long totalLength = cutTree(arr,mid);
            if(totalLength<m){
                end = mid-1;
            }else{
                start = mid+1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }

    private static long cutTree(int[] arr, int mid) {  // O(N)
        long total=0;
        for(int i=0;i<arr.length;i++){
            int bufLength = arr[i]-mid;
            if(bufLength<0)
                bufLength=0;
            total +=bufLength;
        }
        return total;
    }
}
