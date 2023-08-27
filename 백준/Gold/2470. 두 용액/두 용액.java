import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ansAbs = 2000000000;
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0;i<n-1;i++){
            int pairValue = findOptimalPairValue(arr,i+1,n-1,arr[i]);
            int abs = Math.abs(arr[i]+pairValue);
            if(abs<ansAbs) {
                ansAbs = abs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }

        System.out.println(ans1+" "+ans2);
    }

    private static int findOptimalPairValue(int[] arr, int startIndex, int endIndex,int value) {
        
        int optimalPairValue = 0;
        int start = startIndex;
        int end = endIndex;
        int optimalPariAbs =2000000000;
         while(start<=end){
             int m = (start+end)/2;
             int sum = value+arr[m];
             int sumAbs = Math.abs(sum);
             if(sumAbs<optimalPariAbs){
                 optimalPairValue = arr[m];
                 optimalPariAbs = sumAbs;
             }
             if(sum<0) {
                 start = m+1;
             }
             else if(sum>0){
                 end = m-1;
             }
             else
                 return optimalPairValue;
         }

         return optimalPairValue;
    }
}
