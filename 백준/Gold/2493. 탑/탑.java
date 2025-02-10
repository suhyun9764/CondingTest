import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 탑의 수 N 입력받기
        int N = Integer.parseInt(br.readLine());
        // 2. N개의 탑 높이 입력 받기
        Deque<int[]> stack = new ArrayDeque<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            stack.push(new int[]{i+1, Integer.parseInt(s[i])});
        }

        // 3. 스택에서 pop을 하여 저장하고 자신보다 큰 수가 나올때까지 반복하기
        Deque<int[]> bufferStack = new ArrayDeque<>();
        int[] answer = new int[N];


        while (!stack.isEmpty()) {
            int[] currentTop = stack.pop();
            while(!bufferStack.isEmpty()&&bufferStack.peek()[1]<currentTop[1]){
                int[] pop = bufferStack.pop();
                answer[pop[0]-1] = currentTop[0];
            }
            bufferStack.push(currentTop);
        }

        while(!stack.isEmpty()){
            int[] currentTop = bufferStack.pop();
            answer[currentTop[0]] = 0;
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
