
import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static Shark[] sharks;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        setting();
        for (int i = 0; i < C; i++) {
            catchShark(i);
            move();
            eat();
        }
        System.out.println(answer);
    }

    private static void eat() {
        Shark[][] newMap = new Shark[R][C];

        for (Shark shark : sharks) {
            if (shark == null) continue;
            int r = shark.r, c = shark.c;
            if (newMap[r][c] == null || newMap[r][c].z < shark.z) {
                newMap[r][c] = shark;
            }
        }

        List<Shark> newSharks = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (newMap[r][c] != null) newSharks.add(newMap[r][c]);
            }
        }
        sharks = newSharks.toArray(new Shark[0]);
    }

    private static void move() {
        for (Shark shark : sharks) {
            if (shark != null) shark.nextPosition();
        }
    }

    private static void catchShark(int i) {
        int sharkIdx = -1;
        int minRow = Integer.MAX_VALUE;

        for (int s = 0; s < sharks.length; s++) {
            if (sharks[s] == null) continue;
            if (sharks[s].c == i && sharks[s].r < minRow) {
                minRow = sharks[s].r;
                sharkIdx = s;
            }
        }

        if (sharkIdx != -1) {
            answer += sharks[sharkIdx].z;
            sharks[sharkIdx] = null;
        }
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new Shark[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, d, z);
        }
    }

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public void nextPosition() {
            if (d == 1 || d == 2) {
                int cycle = (R - 1) * 2;
                int move = s % cycle;
                for (int i = 0; i < move; i++) {
                    if (d == 1 && r == 0) d = 2;
                    else if (d == 2 && r == R - 1) d = 1;
                    r += (d == 1) ? -1 : 1;
                }
            } else {
                int cycle = (C - 1) * 2;
                int move = s % cycle;
                for (int i = 0; i < move; i++) {
                    if (d == 4 && c == 0) d = 3;
                    else if (d == 3 && c == C - 1) d = 4;
                    c += (d == 4) ? -1 : 1;
                }
            }
        }
    }
}
