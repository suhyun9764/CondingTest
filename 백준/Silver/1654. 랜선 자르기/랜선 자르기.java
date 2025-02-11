import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        long[] lans = new long[k];

        long max = 0;
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if(max<lans[i])
                max = lans[i];
        }

        long min = 1;
        long answer = 0;
        while (min<=max){
            long m = (min+max)/2;
            int totalNumber = 0;
            for (long lan : lans) {
                totalNumber+=(lan/m);
            }
            if(totalNumber>=N){
                min = m+1;
                answer = m;
            }else{
                max = m-1;
            }
        }

        System.out.println(answer);
    }

}
