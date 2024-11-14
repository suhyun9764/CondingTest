import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
	private static int T;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			int answer = getAnswer(br);
			System.out.print("#" + (testCase + 1 + " "));
			System.out.println(answer);
		}
	}

	private static int getAnswer(BufferedReader br) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		Set<Integer> checkSet = new HashSet<>();
		int currentN = N;
		int count = 0;
		while (checkSet.size() < 10) {
			currentN = (count + 1)*N;
			String[] eachNumbers = String.valueOf(currentN).split("");
			for (String number : eachNumbers) {
				int currentNumber = Integer.parseInt(number);
				checkSet.add(currentNumber);
				
			}
			count++;

		}
		return currentN;
	}
}
