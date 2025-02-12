import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = '*';
            }
        }
        makeBlank(N/3,N/3,N);

        for(int i=0;i<N;i++){
            System.out.println(board[i]);
        }
    }

    private static void makeBlank(int y, int x,int n) {
        if(n==1)
            return;

        for(int i=y;i<y+n/3;i++){
            for(int j=x;j<x+n/3;j++){
                board[i][j] = ' ';
            }
        }

        n/=3;
        makeBlank(y+n/3,x-2*n/3,n);//좌
        makeBlank(y+n/3,x+4*n/3,n);//우
        makeBlank(y-2*n/3,x+n/3,n);//상
        makeBlank(y+4*n/3,x+n/3,n);//하
        makeBlank(y-2*n/3,x-2*n/3,n);//좌상
        makeBlank(y-2*n/3,x+4*n/3,n);// 우상
        makeBlank(y+4*n/3,x-2*n/3,n);//좌하
        makeBlank(y+4*n/3,x+4*n/3,n);//우하
    }
}
