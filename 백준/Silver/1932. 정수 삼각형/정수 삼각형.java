import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];


        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=2;i<=N;i++){
            for(int j=1;j<=i;j++){
                if(j==1){
                    board[i][j] = board[i][j] + board[i-1][j];
                    continue;
                }

                if(j==i) {
                    board[i][j] = board[i][j] + board[i - 1][j - 1];
                    continue;
                }

                board[i][j] = board[i][j] + Math.max(board[i-1][j-1],board[i-1][j]);
            }
        }

        int answer = Arrays.stream(board[N]).max().getAsInt();
        System.out.println(answer);

    }

}
