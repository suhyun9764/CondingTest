import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int cArr[];
	static int nowArr[];
	static int checkSecret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int cnt=0;
		char[] dArr = new char[S];
		dArr = br.readLine().toCharArray();
		
		cArr = new int[4];
		nowArr= new int[4];
		checkSecret =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			cArr[i] = Integer.parseInt(st.nextToken());
			if(cArr[i]==0)
				checkSecret++;
		}
		
		for(int i=0;i<P;i++) {
			ADD(dArr[i]);
		}
		if(checkSecret==4)
			cnt++;
		
		for(int i=P;i<S;i++) {
			int j = i-P;
			ADD(dArr[i]);
			REMOVE(dArr[j]);
			if(checkSecret == 4)
				cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
	
	private static void ADD(char c) {
		switch(c) {
		case 'A':
			nowArr[0]++;
			if(nowArr[0]==cArr[0])
				checkSecret++;
			break;
		
		case 'C':
			nowArr[1]++;
			if(nowArr[1]==cArr[1])
				checkSecret++;
			break;
		case 'G':
			nowArr[2]++;
			if(nowArr[2]==cArr[2])
				checkSecret++;
			break;
		case 'T':
			nowArr[3]++;
			if(nowArr[3]==cArr[3])
				checkSecret++;
			break;
		}
	}
	
	private static void REMOVE(char c) {
		switch(c) {
		case 'A':
			if(nowArr[0]==cArr[0])
				checkSecret--;
			nowArr[0]--;
			break;
		
		case 'C':
			
			if(nowArr[1]==cArr[1])
				checkSecret--;
			nowArr[1]--;
			break;
		case 'G':
			
			if(nowArr[2]==cArr[2])
				checkSecret--;
			nowArr[2]--;
			break;
		case 'T':
			if(nowArr[3]==cArr[3])
				checkSecret--;
			nowArr[3]--;
			break;
		}
	}

}