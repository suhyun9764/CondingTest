import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] aArr = new int[n];
		Queue<Integer> bQueue = new PriorityQueue<>(Comparator.reverseOrder());

		String[] aSplit = br.readLine().split(" ");

		String[] bSplit = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			aArr[i] = Integer.parseInt(aSplit[i]);
		}
		Arrays.sort(aArr);

		for (int i = 0; i < n; i++) {
			bQueue.add(Integer.parseInt(bSplit[i]));
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer += aArr[i] * bQueue.poll();
		}

		System.out.println(answer);
	}
}
