
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] board;
    static int[] dy = {-1,-1,0};
    static int[] dx = {0,-1,-1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        setiing();

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                int min = 1001;
                if(board[i][j]==0) continue;
                for(int d=0;d<3;d++){
                    int ny = i+dy[d];
                    int nx = j+dx[d];
                    if(min>board[ny][nx])
                        min = board[ny][nx];
                }
                if(min<1001){
                    board[i][j] = min+1;
                    answer = Math.max(answer,board[i][j]);
                }
            }
        }

        System.out.println(answer*answer);
    }

    private static void setiing() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            if(i==0) {
                Arrays.fill(board[i],0);
                continue;
            }
            char[] input = br.readLine().toCharArray();
            for(int j=0;j<m+1;j++){
                if(j==0) {
                    board[i][j] = 0;
                    continue;
                }
                board[i][j] = Integer.parseInt(String.valueOf(input[j-1]));
            }
        }
    }
}
