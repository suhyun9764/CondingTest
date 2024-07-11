
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int target1;
	private static int target2;
	private static boolean[] visited;
	private static int[][] oneChons;
	private static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		target1 = Integer.parseInt(st.nextToken());
		target2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		oneChons = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			oneChons[parent][child] = 1;
			oneChons[child][parent] = 1;
		}

		dfs(target1, 0);

		System.out.println(answer);

	}

	private static void dfs(int currentPerson, int chon) {
		visited[currentPerson] = true;
		Set<Integer> myOneChons = getMyOneChons(currentPerson);

		if (currentPerson == target2) {
			answer = chon;
		}

		for (int myOneChon : myOneChons) {
			if (visited[myOneChon] == false) {
				dfs(myOneChon, chon + 1);
			}
		}
	}

	private static Set<Integer> getMyOneChons(int currentPerson) {
		Set<Integer> myOneChons = new HashSet<>();
		for (int i = 1; i < n + 1; i++) {
			if (oneChons[currentPerson][i] == 1)
				myOneChons.add(i);
			if (oneChons[i][currentPerson] == 1)
				myOneChons.add(i);
		}

		return myOneChons;
	}


}
