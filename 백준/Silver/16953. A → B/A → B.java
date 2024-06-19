import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int changeNumber = 0;
		boolean isMatch = false;

		while(a<=b){
			if(a==b){
				changeNumber++;
				isMatch = true;
				break;
			}
			int lastNumber = b%10;
			// 끝자리가 1일 때
			if(lastNumber==1){
				b /= 10;
				changeNumber++;
			} else if (lastNumber%2==0) {
				b /= 2;
				changeNumber++;
			}else{
				break;
			}
		}
		if(isMatch) {
			System.out.println(changeNumber);
			return;
		}

		System.out.println(-1);


	}
}
