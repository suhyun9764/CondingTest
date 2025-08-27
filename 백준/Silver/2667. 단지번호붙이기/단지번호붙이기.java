import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static boolean[][] visit;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=0;j<charArray.length;j++){
                map[i][j] = charArray[j]-'0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1&&!visit[i][j]) {
                    visit[i][j] =true;
                    answer.add(dfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }

    private static int dfs(int y, int x) {
        int sum = 1;
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};

        for(int d=0;d<4;d++){
            int ny = y+dy[d];
            int nx = x+dx[d];

            if(ny<0||ny>=N||nx<0||nx>=N) continue;
            if(map[ny][nx]==1&&!visit[ny][nx]){
                visit[ny][nx] = true;
                sum+=dfs(ny,nx);
            }
        }

        return sum;
    }
}
