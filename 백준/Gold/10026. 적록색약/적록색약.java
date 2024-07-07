
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static BufferedReader br;
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		normal();
		blindness();
	}

	private static void blindness() {
		visited = new boolean[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]=='R')
					map[i][j]='G';
			}
		}


		int answer = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if (visited[i][j]==false) {
					dfs(i,j);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	private static void normal() {
		visited = new boolean[N][N];
		int answer = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if (visited[i][j]==false) {
					dfs(i,j);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int i, int j) {
		List<int[]> nearSameColors = findSameColor(i,j);
		if(nearSameColors.isEmpty())
			return;

		for (int[] nearSameColor : nearSameColors) {
			dfs(nearSameColor[0],nearSameColor[1]);
		}

	}

	private static List<int[]> findSameColor(int i, int j) {
		char currentColor = map[i][j];
		int x[] = {0,-1,0,1};
		int y[] = {1,0,-1,0};
		List<int[]> nearSameColors = new ArrayList<>();
		for(int t=0;t<4;t++){
			if(0<=i+y[t]&&i+y[t]<map.length&&0<=j+x[t]&&j+x[t]<map[0].length){
				if(map[i+y[t]][j+x[t]]==currentColor&&visited[i+y[t]][j+x[t]]==false){
					nearSameColors.add(new int[]{i+y[t],j+x[t]});
					visited[i+y[t]][j+x[t]] = true;
				}
			}
		}

		return nearSameColors;
	}
}
