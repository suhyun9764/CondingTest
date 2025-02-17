import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// dfs + 백트래킹
// 0인 모든 좌표를 zero라는 ArrayList에 담는다. <= 2차원배열 순회하면서 0처리 x
// Zero의 0 번째 좌표부터 시작
public class Main {
    static int board[][] = new int[9][9];
    public static void main(String[] args) throws IOException {
        setting();
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                // 이미 채워져있으면 pass
//                if(board[i][j]!=0) continue;
//                // 1~9까지 탐색
//                for(int k=1;k<10;k++){
//                    if(checkI(i,k)&&checkJ(j,k)&&checkSmallBox(i,j,k)) {
//                        board[i][j] = k;
//                    }
//                }
//            }
//
//        }
        dfs(0,0);


    }

    private static void dfs(int y, int x) {
        if(x==9){
            dfs(y+1,0);
            return;
        }

        if(y==9){
            printBoard();
            System.exit(0);
        }

        if(board[y][x] == 0){
            for(int num=1;num<10;num++){
                if(checkI(y,num)&&checkJ(x,num)&&checkSmallBox(y,x,num)){
                    board[y][x] = num;
                    dfs(y,x+1);
                    board[y][x] = 0;
                }
            }
        }else{
            dfs(y,x+1);
        }
    }

    private static boolean checkI(int i, int k) {
        for(int t=0;t<9;t++){
            if(board[i][t]==k)
                return false;
        }

        return true;
    }

    private static boolean checkJ(int j, int k) {
        for(int t=0;t<9;t++){
            if(board[t][j]==k)
                return false;
        }

        return true;
    }

    private static boolean checkSmallBox(int i, int j, int k) {
        int iMin = (i/3)*3;
        int jMin = (j/3)*3;

        for(int p=iMin;p<iMin+3;p++){
            for(int q=jMin;q<jMin+3;q++){
                if(board[p][q]==k)
                    return false;
            }
        }

        return true;
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++){
            String[] split = br.readLine().split("");
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
