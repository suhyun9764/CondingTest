
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static final char THREE = '3';
	private static final char SIX = '6';
	private static final char NINE = '9';
	private static final char BAR = '-';
	private static final String BLANK = " ";
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = getN();
		threeSixNine(N);
	}
	
	private static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		return N;
	}


	private static void threeSixNine(int N) {
		// 1부터 N까지 순회
		for(int i=1;i<N+1;i++) {
			printEachUnit(i);
		}
	}

	private static void printEachUnit(int i) {
		// 모든 자릿수 탐색하여 3,6,9가 있으면 -로 대체
		char[] units = String.valueOf(i).toCharArray();
		int count = 0;
		for(int j=0;j<units.length;j++) {
			char unit = units[j];
			if(unit==THREE||unit==SIX||unit==NINE) {
				count++;
			}
		}
		if(count==1)
			System.out.print("- ");
		else if(count==2)
			System.out.print("-- ");
		else if(count==3)
			System.out.print("--- ");
		else
			System.out.print(i+" ");
					
	}
}