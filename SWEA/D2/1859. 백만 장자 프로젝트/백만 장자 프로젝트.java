import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			String[] stringPrices=br.readLine().split(" ");
			Long[] prices = new Long[N];
			int startPosition = 0;
			Long totalBenefit = 0L;
			
			while(startPosition<N) {
				// 최대값 찾기
				Long max = 0L;
				int maxPosition = 0;
				for(int j=startPosition;j<N;j++) {
					prices[j]= Long.parseLong(stringPrices[j]);
					if(max<prices[j]) {
						max = prices[j];
						maxPosition = j;
					}	
				}
				// 최대값 전날까지의  모든 수익 더하기
				Long benefit = 0L;
				for(int k=startPosition;k<maxPosition;k++) {
					benefit+=prices[maxPosition]-prices[k];
				}
				totalBenefit+=benefit;
				maxPosition+=1;
				startPosition=maxPosition;
			}
			System.out.println("#"+(i+1)+" "+totalBenefit);
		}
	}
}
