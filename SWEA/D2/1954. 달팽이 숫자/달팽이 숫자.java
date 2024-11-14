import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T;
	private static int N;
	private static int[][] snail;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			String answer = getAnswer(br);
			System.out.println("#" + (testCase + 1));
			System.out.print(answer);
		}

	}

	private static String getAnswer(BufferedReader br) throws NumberFormatException, IOException {
		setting(br);
		int currentNumber = 1;
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int[] currentPosition = { 0, 0 };
		boolean isEnd = false;

		int directionsNumber = 0;
		while (currentNumber <= N * N) {
			// 앞이 막힐때마다 방향 전환
			if (isEnd) {
				currentPosition[0] -= directions[directionsNumber][0];
				currentPosition[1] -= directions[directionsNumber][1];
				directionsNumber++;
				directionsNumber %= 4;
				currentPosition[0] += directions[directionsNumber][0];
				currentPosition[1] += directions[directionsNumber][1];
				isEnd = false;
			}

			if (currentPosition[0] >= 0 && currentPosition[0] < N && currentPosition[1] >= 0 && currentPosition[1] < N
					&& snail[currentPosition[1]][currentPosition[0]] == 0) {

				snail[currentPosition[1]][currentPosition[0]] = currentNumber;
				currentNumber++;
				currentPosition[0] += directions[directionsNumber][0];
				currentPosition[1] += directions[directionsNumber][1];

			} else {
				isEnd = true;
			}
		}
		String answer = "";
		for (int height = 0; height < N; height++) {
			for (int width = 0; width < N; width++) {
				answer += snail[height][width] + " ";
			}
			answer += "\n";
		}
		return answer;
	}

	private static void setting(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		snail = new int[N][N];
	}

}