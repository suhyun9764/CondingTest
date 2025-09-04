
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
//        int len = 0;
//
//        int answer = 0;
//        for(int i=0;i<n;i++){
//            dp[i] = 1;
//            for(int j=0;j<i;j++){
//                if(arr[j]<arr[i]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//            answer = Math.max(dp[i],answer);
//        }
//
//        System.out.println(answer);

        int len =0;
        for(int i=0;i<n;i++){
            int cur = arr[i];
            int pos = lowerBound(dp,0,len,cur);
            dp[pos] = cur;
            if(pos==len)
                len++;
        }

        System.out.println(len);

    }

    private static int lowerBound(int[] dp, int left, int right, int target) {
        while (left<right){
            int mid = (right+left)/2;
            if(dp[mid]<target){
                left = mid+1;
            }else{
                right=mid;
            }
        }

        return left;
    }
}
