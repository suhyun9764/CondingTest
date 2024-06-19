import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int answer = 0;
		for(int i=0;i<n;i++){
			char[] charArray = String.valueOf(i).toCharArray();
			int result = i;
			for(int c =0;c<charArray.length;c++){
				result+=Integer.parseInt(String.valueOf(charArray[c]));
			}

			if(result==n){
				answer = i;
				break;
			}
		}

		System.out.println(answer);

	}
}
