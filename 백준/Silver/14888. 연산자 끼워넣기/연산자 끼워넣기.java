import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static final int ADD = 0;
    static final int SUBTRACT = 1;
    static final int MULTIPLE = 2;
    static final int DIVIDE = 3;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for(int i=0;i<numbers.length;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[] operators = new int[4];
        st =  new StringTokenizer(br.readLine());
        for(int i=0;i<operators.length;i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,numbers[0], operators);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth,int result,int[] operators) {
        if(depth==N-1){
            max = Math.max(max,result);
            min = Math.min(min,result);
            return;
        }

        for(int i=0;i<4;i++){
            if(operators[i]==0) continue;
            switch (i){
                case ADD:
                {
                    operators[ADD] -=1;
                    dfs(depth+1,result+numbers[depth+1],operators);
                    operators[ADD] +=1;
                    break;
                }
                case SUBTRACT:
                {
                    operators[SUBTRACT] -=1;
                    dfs(depth+1,result-numbers[depth+1],operators);
                    operators[SUBTRACT] +=1;
                    break;
                }
                case MULTIPLE:
                {
                    operators[MULTIPLE] -=1;
                    dfs(depth+1,result*numbers[depth+1],operators);
                    operators[MULTIPLE] +=1;
                    break;
                }
                case DIVIDE:
                {
                    operators[DIVIDE] -=1;
                    dfs(depth+1,result/numbers[depth+1],operators);
                    operators[DIVIDE] +=1;
                    break;
                }
            }
        }
    }
}
