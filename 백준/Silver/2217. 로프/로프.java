
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes); // 오름차순 정렬

        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            // (n - i)개의 로프가 현재의 로프를 사용할 때 최대 중량을 계산
            int currentWeight = ropes[i] * (n - i);
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }

        System.out.println(maxWeight);
    }
}
