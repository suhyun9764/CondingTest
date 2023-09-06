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
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int min = 10001;
        int max = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]<min)
                min = arr[i];
            if(arr[i]>max)
                max = arr[i];
        }



        int start = max;
        int end = 10000*n;
        int k = 0;
        while (start<=end){
            int mid = (start+end)/2;
            int cnt = getTotalNum(mid,arr);
            if(cnt>m)
                start = mid+1;
            else{
                end = mid - 1;
                k = mid;
            }
        }

        System.out.println(k);

    }

    private static int getTotalNum(int mid, int[] arr) {
        int totalNum =1;
        int currentMoney = mid;
        for(int i=0;i<arr.length;i++){
            if(currentMoney<arr[i]) {
                totalNum++;
                currentMoney = mid;
            }
            currentMoney -= arr[i];

        }

        return totalNum;
    }
}
