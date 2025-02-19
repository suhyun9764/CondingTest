
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int MIN_BAG = 3;
    static int MAX_BAG = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        int answer = getAnswer(N);
//        System.out.println(answer);
        System.out.println(dp(N));
    }


    private static int dp(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,5001);
        if(n<=5){
            if(n==3||n==5) return 1;
            return -1;
        }
        // 초기값 설정
        arr[3] = 1;
        arr[5] = 1;

        for(int i=6;i<=n;i++){
            arr[i] = Math.min(arr[i-3],arr[i-5])+1;
        }
        return arr[n]>=5001?-1:arr[n];
    }

    private static int getAnswer(int n) {
        int maxBagNum = n/MAX_BAG;
        int answer = -1;
        while (maxBagNum>=0){
            int remain = n - maxBagNum*MAX_BAG;
            if(remain%MIN_BAG==0){
                answer = maxBagNum+(remain/MIN_BAG);
                break;
            }
            maxBagNum--;
        }
        return answer;
    }
}
