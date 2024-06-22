
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static char[][] board;
	private static char[][] startWithWChess = new char[8][8];
	private static char[][] startWithBChess = new char[8][8];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new char[n][m];
		for(int i=0;i<n;i++){
			board[i] = br.readLine().toCharArray();
		}

		char[] startWithW = {'W','B','W','B','W','B','W','B'};
		char[] startWithB = {'B','W','B','W','B','W','B','W'};


		makeChess(startWithW,startWithB);

		int min = 64;

		for(int i=0;i<n-7;i++){
			for(int j=0;j<m-7;j++){
				int haveToChangeNum = getChangeNum(i,j);
				if(min>haveToChangeNum)
					min = haveToChangeNum;
			}
		}

		System.out.println(min);


	}

	private static void makeChess(char[] startWithW, char[] startWithB) {
		for(int i=0;i<8;i++){
			if(i%2==0){
				startWithBChess[i] = startWithB;
				startWithWChess[i] = startWithW;
			} else{
				startWithBChess[i] = startWithW;
				startWithWChess[i] = startWithB;
			}

		}
	}

	private static int getChangeNum(int i, int j) {
		int changeNumWithStartW = getWithStartW(i,j);
		int changeNumWithStartB = getWithStartB(i,j);

		int minChangeNum = Math.min(changeNumWithStartW, changeNumWithStartB);

		return minChangeNum;
	}

	private static int getWithStartB(int i, int j) {
		int changeNumWithStartB = 0;
		for(int n = 0;n<8;n++){
			for(int m = 0;m<8;m++){
				if(startWithBChess[n][m]!=board[n+i][m+j])
					changeNumWithStartB++;
			}
		}

		return changeNumWithStartB;
	}

	private static int getWithStartW(int i, int j) {
		int changeNumWithStartW = 0;
		for(int n = 0;n<8;n++){
			for(int m = 0;m<8;m++){
				if(startWithWChess[n][m]!=board[n+i][m+j])
					changeNumWithStartW++;
			}
		}

		return changeNumWithStartW;
	}
}
