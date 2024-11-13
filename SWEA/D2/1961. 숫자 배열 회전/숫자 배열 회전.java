
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T;
	private static int N;
	private static int[][] board;
	private static String[] answers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int testCase=0;testCase<T;testCase++) {
			getAnswer(br);
			System.out.println("#"+(testCase+1));
			for(int i=0;i<answers.length;i++) {
				System.out.print(answers[i]);
			}
			System.out.println();
		}

	}

	private static void getAnswer(BufferedReader br) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		makeBoard(br);
		answers = new String[N];
		// 90도 회전
		get90();
		// 180도 회전
		get180();
		// 270도 회전
		get270();
	}

	private static void get270() {
		int count=0;
		for(int width=N-1;width>=0;width--) {
			String answer = "";
			for(int height=0;height<N;height++) {
				answer+=board[height][width];
			}
			if(count<N-1) {
				answers[count]+=answer+"\n";
			}
			else {
				answers[count]+=answer;
			}
			count++;
		}
	}

	private static void get180() {
		int count =0;
		for(int height=N-1;height>=0;height--) {
			String answer = "";
			for(int width=N-1;width>=0;width--) {
				answer+=board[height][width];
			}
			answers[count]+=answer;
			answers[count]+=" ";
			count++;
		}
	}

	private static void get90() {
		for(int width=0;width<N;width++) {
			String answer = "";
			for(int height=N-1;height>=0;height--) {
				answer+=board[height][width];
			}
			answers[width]=answer;
			answers[width]+=" ";
		}
	}

	private static void makeBoard(BufferedReader br) throws IOException {
		board = new int[N][N];
		for(int height=0;height<N;height++) {
			String[] inputNumbers = br.readLine().split(" ");
			for(int width=0;width<N;width++) {
				board[height][width] = Integer.parseInt(inputNumbers[width]);
			}
		}
	}

}
