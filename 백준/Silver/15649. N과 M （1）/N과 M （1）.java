import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        visited = new boolean[N + 1]; // 방문 체크 배열
        result = new int[M]; // 결과를 저장할 배열

        backtrack(0);
    }

    static void backtrack(int depth) {
        if (depth == M) { // M개를 모두 선택했을 경우 출력
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 선택하지 않은 숫자라면
                visited[i] = true; // 방문 체크
                result[depth] = i; // 현재 위치에 숫자 저장
                backtrack(depth + 1); // 다음 숫자 선택
                visited[i] = false; // 백트래킹 (원상 복구)
            }
        }
    }
}
