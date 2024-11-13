import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
	private static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		// 테스트 순회
		for(int i=0;i<T;i++) {
			String inputValue = br.readLine();
			int answer = 0;
			// 패턴 찾기
			answer = findPattern(inputValue, answer);
			System.out.println("#"+(i+1)+" "+answer);
		}
	}

	private static int findPattern(String inputValue, int answer) {
		for(int length=1;length<10;length++) {
			String pattern = inputValue.substring(0,length);
			if(inputValue.startsWith(pattern+pattern)){
				answer=length;
				break;
			}
		}
		return answer;
	}

}
