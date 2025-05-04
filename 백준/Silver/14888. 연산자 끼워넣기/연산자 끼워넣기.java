
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numArr;
    private static int[] operators = new int[4];
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<operators.length;i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numArr[0],1);

        System.out.printf(max+"\n"+min);



    }

    private static void dfs(int num, int depth) {
        if(depth == N){
            min = Math.min(min, num);
            max = Math.max(max,num);
        }

        for(int i=0;i<4;i++){
            if(operators[i]>0){
                operators[i]-=1;

                switch (i){
                    case 0 :
                        dfs(num+numArr[depth], depth+1);
                        break;
                    case 1 :
                        dfs(num-numArr[depth], depth+1);
                        break;
                    case 2 :
                        dfs(num*numArr[depth], depth+1);
                        break;
                    case 3 :
                        dfs(num/numArr[depth], depth+1);
                        break;
                }

                operators[i]+=1;
            }
        }
    }
}
