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

        int[] arr = new int[n+1];
        int[] sumArr = new int[n+1];
        int totalLength = 0;
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            totalLength +=arr[i];
        }

        for(int i=1;i<n+1;i++){
            sumArr[i] = sumArr[i-1]+arr[i];
        }


        int maxDistance = totalLength/2;
        int max = 0;

        for(int i=0;i<n;i++){
            int end =i+1;
            while (sumArr[end]-sumArr[i]<=maxDistance&&end<n){
                if(sumArr[end+1]-sumArr[i]<=maxDistance)
                    end++;

                else
                    break;
            }
            int distance = sumArr[end]-sumArr[i];
            if(distance<=maxDistance)
                max = Math.max(distance,max);
        }

        System.out.println(max);

    }
}
