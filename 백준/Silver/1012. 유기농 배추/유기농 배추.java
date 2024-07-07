
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int T;
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
			getWarmNumber();
		}
	}

	private static void getWarmNumber() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] farm = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		for(int i=0;i<k;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			farm[y][x] = 1;
		}

		int answer = 0;

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(farm[i][j]==1&&visited[i][j]==false) {
					dfs(i, j, farm, visited);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int i, int j, int[][] farm, boolean[][] visited) {
		List<int[]> near = findNear(i,j,farm,visited);
		if(near.isEmpty())
			return;

		for (int[] n : near) {
			dfs(n[0],n[1], farm,visited);
		}
	}

	private static List<int[]> findNear(int i, int j,int[][] farm, boolean[][] visited) {
		int[] x = {0,-1,0,1};
		int[] y = {1,0,-1,0};
		List<int[]> near = new ArrayList<>();
		for(int t=0;t<4;t++){
			if(0<=i+y[t]&&i+y[t]<farm.length&&0<=j+x[t]&&j+x[t]<farm[0].length){
				if(farm[i+y[t]][j+x[t]]==1&&visited[i+y[t]][j+x[t]]==false){
					near.add(new int[]{i+y[t],j+x[t]});
					visited[i+y[t]][j+x[t]]=true;
				}
			}
		}

		return near;
	}
}
