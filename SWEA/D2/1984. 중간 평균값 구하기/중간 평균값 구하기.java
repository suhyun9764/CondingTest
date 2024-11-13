import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
	private static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int testCase=0;testCase<T;testCase++) {
			int answer = getAnswer(br);
			System.out.print("#"+(testCase+1)+" ");
			System.out.println(answer);
		}

	}

	private static int getAnswer(BufferedReader br) throws IOException {
		String[] input = br.readLine().split(" ");
		int[] numbers = new int[10];
		for(int i=0;i<10;i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(numbers);
		int sum =0;
		
		for(int i=1;i<9;i++) {
			sum+=numbers[i];
		}
		int average = Math.round((float)sum/8);
		return average;
	}

}