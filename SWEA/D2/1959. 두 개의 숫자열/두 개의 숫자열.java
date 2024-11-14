import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T;
	private static int N;
	private static int M;
	private static int[] nArr;
	private static int[] mArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase=0;testCase<T;testCase++) {
			int answer = getAnswer(br);
			System.out.print("#"+(testCase+1)+" ");
			System.out.println(answer);
		}

	}

	private static int getAnswer(BufferedReader br) throws IOException {
		setting(br);
		if(N==Math.min(N,M)){
			return calculateByN();
		}
		
		return calculateByM();
	}

	private static int calculateByM() {
		int max = 0;
		int startPosition = 0;
		while(startPosition+M-1<N) {
			int current = 0;
			for(int mLen=0;mLen<M;mLen++) {
				 current += mArr[mLen]*nArr[startPosition+mLen];
			}
			if(current>max)
				max = current;
			startPosition++;
		}
		return max;
	}

	private static int calculateByN() {
		int max = 0;
		int startPosition = 0;
		while(startPosition+N-1<M) {
			int current = 0;
			for(int nLen=0;nLen<N;nLen++) {
				 current += nArr[nLen]*mArr[startPosition+nLen];
			}
			if(current>max)
				max = current;
			startPosition++;
		}
		return max;
	}

	private static void setting(BufferedReader br) throws IOException {
		String[] nAndM = br.readLine().split(" ");
		N = Integer.parseInt(nAndM[0]);
		M = Integer.parseInt(nAndM[1]);
		nArr = new int[N];
		mArr = new int[M];
		String[] nArrInput = br.readLine().split(" ");
		String[] mArrInput = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			nArr[i] = Integer.parseInt(nArrInput[i]);
		}
		for(int i=0;i<M;i++) {
			mArr[i] = Integer.parseInt(mArrInput[i]);
		}
	}

}