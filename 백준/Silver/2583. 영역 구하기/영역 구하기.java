
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int M;
	private static int N;
	private static int K;
	private static boolean[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[M][N];
		visited = new boolean[M][N];
		makeMap(br);

		int areaNum = 0;
		List<Integer> areaSizes = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j] && !visited[i][j]) {
					areaSizes.add(dfs(i, j));
					areaNum++;
				}
			}
		}

		Collections.sort(areaSizes);
		System.out.println(areaNum);
		for (int size : areaSizes) {
			System.out.print(size + " ");
		}
	}

	private static int dfs(int i, int j) {
		visited[i][j] = true;
		int size = 1;

		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};

		for (int d = 0; d < 4; d++) {
			int ni = i + dy[d];
			int nj = j + dx[d];

			if (ni >= 0 && ni < M && nj >= 0 && nj < N && !map[ni][nj] && !visited[ni][nj]) {
				size += dfs(ni, nj);
			}
		}

		return size;
	}

	private static void makeMap(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			int yStart = M - ry;
			int yLayerNum = ry - ly;
			int xStart = lx;
			int xLayerNum = rx - lx;

			for (int j = yStart; j < yStart + yLayerNum; j++) {
				for (int k = xStart; k < xStart + xLayerNum; k++) {
					map[j][k] = true;
				}
			}
		}
	}
}
