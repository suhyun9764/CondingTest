
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T = 10;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 0; testCase < T; testCase++) {
			int answer = getAnswer(br);
			System.out.print("#" + (testCase + 1) + " ");
			System.out.println(answer);
		}

	}

	private static int getAnswer(BufferedReader br) throws NumberFormatException, IOException {
		int[] boxes = new int[100];

		N = Integer.parseInt(br.readLine());

		String[] inputBoxes = br.readLine().split(" ");
		int count = 0;
		for (String inputBox : inputBoxes) {
			boxes[count++] = Integer.parseInt(inputBox);
		}

		int answer = 0;
		for (int dump = 0; dump < N; dump++) {
			// 가장 큰 곳 찾기
			int max = 0;
			int min = 100;
			int maxPosition = 0;
			int minPosition = 0;

			for (int i = 0; i < 100; i++) {
				if (boxes[i] > max) {
					max = boxes[i];
					maxPosition = i;
				}
				if (boxes[i] < min) {
					min = boxes[i];
					minPosition = i;
				}
			}

			boxes[maxPosition]--;
			boxes[minPosition]++;

			answer = max - min;
			if (answer < 2)
				break;
		}

		int max = -1;
		int min = 101;
		for (int i = 0; i < 100; i++) {
			if (boxes[i] > max) {
				max = boxes[i];
			}
			if (boxes[i] < min) {
				min = boxes[i];
			}
		}

		return max-min;
	}

}
