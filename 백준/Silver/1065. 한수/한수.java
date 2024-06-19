import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if(n<100){
			System.out.println(n);
			return;
		}

		int answer = 99;
		for(int i=100;i<n+1;i++){
			char[] charArray = String.valueOf(i).toCharArray();
			int stdDiff = charArray[1] - charArray[0];
			boolean isSameDiff = true;
			for(int c = 2;c<charArray.length;c++){
				int currentDiff = charArray[c] - charArray[c-1];
				if(stdDiff!=currentDiff){
					isSameDiff = false;
					break;
				}
			}
			if(isSameDiff)
				answer++;
		}

		System.out.println(answer);
	}
}
