
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
			if(a[1]==b[1]){
				return a[0]-b[0];
			}else{
				return a[1]-b[1];
			}
		});
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());

			queue.add(arr);
		}

		int num = 0;
		int[] meeting = queue.poll();
		int endTime = meeting[1];
		num++;

		while (!queue.isEmpty()) {
			meeting = queue.poll();
			if (endTime <= meeting[0]) {
				num++;
				endTime = meeting[1];
			}
		}

		System.out.println(num);

	}
}
