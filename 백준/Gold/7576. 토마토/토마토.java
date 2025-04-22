
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] box;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j]==1)
                    queue.add(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int count = box[y][x];
            int[] dy = {-1,1,0,0};
            int[] dx = {0,0,-1,1};

            for(int d=0;d<4;d++){
                int ny = y +dy[d];
                int nx = x +dx[d];

                if(ny<0||nx<0||ny>=N||nx>=M||box[ny][nx]!=0)continue;
                box[ny][nx] = count+1;
                queue.add(new int[]{ny,nx});
            }

        }

        boolean isComplete = true;
        int answer =0;
        for(int i=0;i<N;i++){
            if(!isComplete)
                break;
            for(int j=0;j<M;j++){
                if(box[i][j]==0){
                    answer=0;
                    isComplete=false;
                    break;
                }
                answer = Math.max(answer,box[i][j]);
            }
        }

        System.out.println(answer-1);


    }
}
