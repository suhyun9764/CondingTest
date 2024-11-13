import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int testCase=0;testCase<T;testCase++) {
			int answer = getAnswer(br);
			System.out.print("#"+(testCase+1)+" ");
			System.out.println(answer);
		}

	}

	private static int getAnswer(BufferedReader br) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int num=1;num<=N;num++) {
			if(num%2==0)
				answer-=num;
			
			else
				answer+=num;
		}
		
		return answer;
	}

}
