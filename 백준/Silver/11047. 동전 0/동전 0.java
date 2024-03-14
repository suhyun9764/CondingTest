import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;
    public static void main(String[] args) throws IOException {
        // 각 동전의 가치를 스택으로 저장하여 하나씩 최대의 금액만큼 가져간다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputSetting(br);
        Stack<Integer> coins = getCoins(n, br);

        int result = getResult(coins);

        System.out.println(result);

    }

    private static void inputSetting(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    private static Stack<Integer> getCoins(int n, BufferedReader br) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            stack.push(Integer.valueOf(st.nextToken()));
        }
        return stack;
    }

    private static int getResult(Stack<Integer> coins) {
        int result = 0;
        while (!coins.isEmpty()||k!=0){
            int currentCoin = coins.pop();
            int coinNum = k / currentCoin;
            result +=coinNum;
            k -= currentCoin*coinNum;
        }
        return result;
    }
}
