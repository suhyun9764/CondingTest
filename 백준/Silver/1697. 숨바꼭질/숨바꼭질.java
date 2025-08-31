import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(n, 0));
        boolean[] visit = new boolean[100001];
        visit[n] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            if (cur.pos == m) {
                answer = cur.time;
                break;
            }

            if (cur.pos + 1 <= 100000 && !visit[cur.pos + 1]) {
                queue.add(new Position(cur.pos + 1, cur.time + 1));
                visit[cur.pos+1] = true;
            }
            if (cur.pos - 1 >= 0 && !visit[cur.pos - 1]) {
                queue.add(new Position(cur.pos - 1, cur.time + 1));
                visit[cur.pos-1] = true;
            }
            if (cur.pos * 2 <= 100000 && !visit[cur.pos * 2]) {
                queue.add(new Position(cur.pos * 2, cur.time + 1));
                visit[cur.pos*2] = true;
            }
        }

        System.out.println(answer);
    }
}

class Position {
    int pos;
    int time;

    public Position(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}
