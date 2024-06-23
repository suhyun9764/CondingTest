
import java.util.Scanner;

public class Main {

	private static int[] chessBoard;
	private static int boardSize;
	private static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boardSize = sc.nextInt();

		chessBoard = new int[boardSize];

		getAnswer(0);

		System.out.println(count);

	}

	private static void getAnswer(int depth) {
		if(depth == boardSize){
			count++;
			return;
		}

		for(int i=0;i<boardSize;i++){
			chessBoard[depth] = i;

			if(isPossible(depth)){
				getAnswer(depth+1);
			}
		}
	}

	private static boolean isPossible(int depth) {
		for(int i=0;i<depth;i++){
			if(chessBoard[depth]==chessBoard[i])
				return false;


			if(Math.abs(chessBoard[depth]-chessBoard[i])==Math.abs(depth-i))
				return false;
		}

		return true;
	}
}
