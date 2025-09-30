import java.util.*;

class Solution {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int[][] board;
        int answer = Integer.MAX_VALUE;

        public int solution(int[][] board, int r, int c) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            this.board = board;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] != 0) {
                        map.putIfAbsent(board[i][j], new ArrayList<>());
                        map.get(board[i][j]).add(new int[]{i, j});
                    }
                }
            }
            List<Integer> cards = new ArrayList<>(map.keySet());
            boolean[] visited = new boolean[cards.size()];
            dfs(cards, visited, new ArrayList<>(), r, c, board, map);
            return answer;
        }

        private void dfs(List<Integer> cards, boolean[] visited, List<Integer> order,
                         int r, int c, int[][] board, Map<Integer, List<int[]>> map) {
            if (order.size() == cards.size()) {
                simulate(order, 0, r, c, 0, board, map);
                return;
            }
            for (int i = 0; i < cards.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    order.add(cards.get(i));
                    dfs(cards, visited, order, r, c, board, map);
                    order.remove(order.size() - 1);
                    visited[i] = false;
                }
            }
        }

        private void simulate(List<Integer> order, int depth, int r, int c, int total,
                              int[][] board, Map<Integer, List<int[]>> map) {
            if (depth == order.size()) {
                answer = Math.min(answer, total);
                return;
            }
            int card = order.get(depth);
            int[] first = map.get(card).get(0);
            int[] second = map.get(card).get(1);

            int d1 = bfs(r, c, first[0], first[1]) + bfs(first[0], first[1], second[0], second[1]) + 2;
            board[first[0]][first[1]] = 0;
            board[second[0]][second[1]] = 0;
            simulate(order, depth + 1, second[0], second[1], total + d1, board, map);
            board[first[0]][first[1]] = card;
            board[second[0]][second[1]] = card;

            int d2 = bfs(r, c, second[0], second[1]) + bfs(second[0], second[1], first[0], first[1]) + 2;
            board[first[0]][first[1]] = 0;
            board[second[0]][second[1]] = 0;
            simulate(order, depth + 1, first[0], first[1], total + d2, board, map);
            board[first[0]][first[1]] = card;
            board[second[0]][second[1]] = card;
        }

        private int bfs(int r, int c, int tr, int tc) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[4][4];
            queue.add(new int[]{r, c, 0});
            visited[r][c] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == tr && cur[1] == tc) return cur[2];
                for (int d = 0; d < 4; d++) {
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];
                    if (ny >= 0 && ny < 4 && nx >= 0 && nx < 4 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx, cur[2] + 1});
                    }
                    int[] ctrl = ctrlMove(cur[0], cur[1], d);
                    if (!visited[ctrl[0]][ctrl[1]]) {
                        visited[ctrl[0]][ctrl[1]] = true;
                        queue.add(new int[]{ctrl[0], ctrl[1], cur[2] + 1});
                    }
                }
            }
            return Integer.MAX_VALUE;
        }

        private int[] ctrlMove(int y, int x, int d) {
            int ny = y, nx = x;
            while (true) {
                int ty = ny + dy[d];
                int tx = nx + dx[d];
                if (ty < 0 || ty >= 4 || tx < 0 || tx >= 4) break;
                ny = ty;
                nx = tx;
                if (board[ny][nx] != 0) break;
            }
            return new int[]{ny, nx};
        }
    }