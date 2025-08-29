import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 0(left) 과 최대값(right)의 절반 구하기 : mid
		// 절반으로 자르고 가져가는 값 구하기
		// 만약 가져가는값이 M보다 크다면 left = mid
		// 만약 가져가는값이 M보다 작다면 RIGHT = MID

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		int max = 0;
		for(int i=0;i<n;i++){
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
			if(value>max)
				max=value;
		}

		int left = 0;
		int right = max;
		int answer = 0;
		while (left<=right){
			int mid = (left+right)/2;
			long total = cut(mid,arr);
			if(total>=m){
				left = mid+1;
				answer = mid;
			}else {
				right = mid - 1;
				}
			}

		System.out.println(answer);
	}

	private static long cut(int mid, int[] arr) {
		long total = 0;
		for (int i : arr) {
			if(i-mid>=0){
				total += i-mid;
			}
		}
		return total;
	}
}
