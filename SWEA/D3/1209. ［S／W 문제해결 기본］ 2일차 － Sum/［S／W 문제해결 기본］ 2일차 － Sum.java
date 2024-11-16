
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T = 10;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 0; testCase < T; testCase++) {
			int testNum = Integer.parseInt(br.readLine());
			int answer = getAnswer(br);
			System.out.print("#" + (testNum) + " ");
			System.out.println(answer);
		}
	}

	private static int getAnswer(BufferedReader br) throws IOException {
		int[][] numbers = new int[100][100];
		for(int height=0;height<100;height++) {
			String[] inputNumbers = br.readLine().split(" ");
			for(int width=0;width<100;width++) {
				numbers[height][width] = Integer.parseInt(inputNumbers[width]);
			}
		}
		
		// 가로에서 맥시멈 찾기
		int max = findWidth(numbers);
		// 세로에서 맥시멈 찾기
		max = Math.max(findHeight(numbers), max);
		// 대각선에서 맥시멈찾기
		max = Math.max(findCross(numbers), max);
		return max;
	}

	private static int findWidth(int[][] numbers) {
		int max = 0;
		for(int height=0;height<100;height++) {
			int sum = 0;
			for(int width=0;width<100;width++) {
				sum+=numbers[height][width];
			}
			max = Math.max(sum, max);
		}
		return max;
	}

	private static int findHeight(int[][] numbers) {
		int max = 0;
		for(int width=0;width<100;width++) {
			int sum = 0;
			for(int height=0;height<100;height++) {
				sum+=numbers[height][width];
			}
			max = Math.max(sum, max);
		}
		return max;
	}

	private static int findCross(int[][] numbers) {
		int max = 0;
		// 아래 크로스
		int sum = 0;
		for(int position=0;position<100;position++) {
			sum+=numbers[position][position];
		}
		max = Math.max(sum, max);
		// 위로 크로스
		sum = 0;
		for(int position=0;position<100;position++) {
			sum+=numbers[99-position][position];
		}
		max = Math.max(sum, max);
		return max;
	}

}
