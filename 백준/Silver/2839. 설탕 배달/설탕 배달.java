import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MIN_BAG = 3;
    static int MAX_BAG = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = getAnswer(N);
        System.out.println(answer);
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
