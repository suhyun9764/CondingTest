import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 문자열 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2. char 배열로 변환
        char[] charArray = br.readLine().toCharArray();
        // 3. 배열 순회하며 -'A' 후 해당 인덱스 arr[i] ++
        int[] arr = new int[30];
        Arrays.fill(arr,0);
        for (char c : charArray) {
            int i = c - 'A';
            arr[i]++;
        }
        // 4. mobis 각 알파벳의 양보다 많은지 확인 아니면 false
        char[] targetArray = "MOBIS".toCharArray();
        for (char t : targetArray) {
            int i = t - 'A';
            if(arr[i]<1) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");

    }
}
