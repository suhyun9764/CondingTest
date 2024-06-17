import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<n;i++){
			queue.add(Integer.valueOf(br.readLine()));
		}

		if(n == 1){
			System.out.println(0);
			return;
		}

		int answer = 0;

		while (queue.size()>1){
			int currentGroup1  = queue.poll();
			int currentGroup2 = queue.poll();

			int totalCurrentGroup = currentGroup1+currentGroup2;
			answer += totalCurrentGroup;
			queue.add(totalCurrentGroup);
		}

		System.out.println(answer);


	}
}
