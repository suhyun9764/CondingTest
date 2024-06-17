import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());

		long currentSum = 0;
		int currentNumber = 1;
		while(currentSum<s){
			currentSum += currentNumber;
			if(currentSum+currentNumber+1<=s){
				currentNumber++;
			}
		}

		System.out.println(currentNumber);

	}
}
