import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;
        int leftAnswer = left;
        int rightAnswer = right;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                leftAnswer = left;
                rightAnswer = right;
            }
            if(sum==0) break;
            if(sum>0){
                right--;
                continue;
            }
            left++;

        }

        System.out.println(arr[leftAnswer]+" "+arr[rightAnswer]);
    }
}