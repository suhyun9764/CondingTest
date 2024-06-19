
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int nearNum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			if(arr[i]>m){
				break;
			}
			for (int j = i + 1; j < arr.length - 1; j++) {
				if(arr[i]+arr[j]>m){
					break;
				}

				for (int k = j + 1; k < arr.length; k++) {
					int currentSum = arr[i] + arr[j] + arr[k];
					if (currentSum > m)
						break;

					if(m-nearNum>m-currentSum)
						nearNum = currentSum;
				}

			}
		}

		System.out.println(nearNum);
	}

}
