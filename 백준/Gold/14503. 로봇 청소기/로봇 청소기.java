//package basic.baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Problem_로봇청소기 {
//    static int N, M;
//    static Robot robot;
//    static int[][] map;
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, -1, 0, 1};
//    static int count = 0;
//
//    public static void main(String[] args) throws IOException {
//        setting();
//        while (true) {
//            // 현재 칸 청소안되었다면
//            robot.clean();
//            // 현재 칸의 주변이 청소가 된경우
//            if (robot.isClean()) {
//                if (robot.canBack()) {//1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//                    robot.goBack();
//                } else {
//                    //2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
//                    break;
//                }
//            } else {  // 청소가 되지 않은 경우
//                // 1. 반시계 방향으로 90도 회전
//                robot.turn();
//                // 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
//                robot.goFront();
//            }
//        }
//        System.out.println(count);
//    }
//
//    private static void setting() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        int y = Integer.parseInt(st.nextToken());
//        int x = Integer.parseInt(st.nextToken());
//        int d = Integer.parseInt(st.nextToken());
//        robot = new Robot(y, x, d);
//
//        map = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//    }
//
//    static class Robot {
//        int y;
//        int x;
//        int d;
//
//        public Robot(int y, int x, int d) {
//            this.y = y;
//            this.x = x;
//            this.d = d;
//        }
//
//        public void clean() {
//            if (map[y][x] == 0) {
//                map[y][x] = -1;
//                count++;
//            }
//        }
//
//        public boolean isClean() {
//            boolean result = true;
//            for (int d = 0; d < 4; d++) {
//                int ny = y + dy[d];
//                int nx = x + dx[d];
//                if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || map[ny][nx] == -1) continue;
//                result = false;
//                break;
//            }
//            return result;
//        }
//
//        public boolean canBack() {
//            switch (d) {
//                case 0:
//                    if (y + 1 >= N || map[y + 1][x] == 1)
//                        return false;
//                    return true;
//                case 1:
//                    if (x - 1 < 0 || map[y][x - 1] == 1)
//                        return false;
//                    return true;
//                case 2:
//                    if (y - 1 < 0 || map[y - 1][x] == 1)
//                        return false;
//                    return true;
//
//                case 3:
//                    if (x + 1 >=M || map[y][x + 1] == 1)
//                        return false;
//                    return true;
//                default:
//                    return true;
//
//            }
//        }
//
//        public void goBack() {
//            switch (d) {
//                case 0:
//                    y += 1;
//                    break;
//                case 1:
//                    x -= 1;
//                    break;
//                case 2:
//                    y -= 1;
//                    break;
//
//                case 3:
//                    x += 1;
//                    break;
//            }
//        }
//
//        public void turn() {
//            switch (d) {
//                case 0:
//                    d = 3;
//                    break;
//                case 1:
//                    d = 2;
//                    break;
//                case 2:
//                    d = 1;
//                    break;
//
//                case 3:
//                    d = 0;
//                    break;
//            }
//        }
//
//        public void goFront() {
//            switch (d) {
//                case 0:
//                    if (y - 1 >= 0 && map[y - 1][x] == 0) {
//                        y -= 1;
//                    }
//                    break;
//                case 1:
//                    if (x + 1 < M && map[y][x + 1] == 0) {
//                        x += 1;
//                    }
//                    break;
//                case 2:
//                    if (y + 1 < N && map[y + 1][x] == 0) {
//                        y += 1;
//                    }
//                    break;
//                case 3:
//                    if (x - 1 >= 0 && map[y][x - 1] == 0) {
//                        x -= 1;
//                    }
//                    break;
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Robot robot;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dx = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        setting();

        while (true) {
            robot.clean(); // 현재 위치 청소

            if (robot.hasDirtyAround()) { // 주변에 청소되지 않은 칸이 있는 경우
                robot.turnLeft(); // 반시계 회전 후
                if (robot.canMove()) {
                    robot.move(); // 이동
                }
            } else { // 주변에 청소할 칸이 없을 때
                if (robot.canBack()) { // 후진 가능하면 후진
                    robot.goBack();
                } else {
                    break; // 후진 불가능하면 작동 멈춤
                }
            }
        }
        System.out.println(count);
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        robot = new Robot(y, x, d);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Robot {
        int y, x, d;

        public Robot(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        public void clean() {
            if (map[y][x] == 0) {
                map[y][x] = -1;
                count++;
            }
        }

        public boolean hasDirtyAround() {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0) {
                    return true;
                }
            }
            return false;
        }

        public void turnLeft() {
            d = (d + 3) % 4; // 반시계 방향 회전
        }

        public boolean canMove() {
            int ny = y + dy[d];
            int nx = x + dx[d];
            return ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0;
        }

        public void move() {
            y += dy[d];
            x += dx[d];
        }

        public boolean canBack() {
            int ny = y - dy[d];
            int nx = x - dx[d];
            return ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] != 1;
        }

        public void goBack() {
            y -= dy[d];
            x -= dx[d];
        }
    }
}
