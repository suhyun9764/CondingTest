
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(N,0));
        visit[N] = true;
        int answer = 0;
        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.position == K) {
                answer = pos.order;
                break;
            }

            if(pos.position-1>=0&&pos.position-1<=100000&&!visit[pos.position-1]) {
                visit[pos.position-1] = true;
                queue.add(new Pos(pos.position - 1, pos.order + 1));
            }

            if(pos.position+1>=0&&pos.position+1<=100000&&!visit[pos.position+1]) {
                visit[pos.position+1] = true;
                queue.add(new Pos(pos.position + 1, pos.order + 1));
            }
            if(pos.position*2>0&&pos.position*2<=100000&&!visit[pos.position*2]) {
                visit[pos.position*2] = true;
                queue.add(new Pos(pos.position * 2, pos.order + 1));
            }
        }
        System.out.println(answer);
    }

    private static class Pos{
        int position;
        int order;

        public Pos(int position, int order){
            this.position = position;
            this.order = order;
        }
    }


}
