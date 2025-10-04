class Result{
        boolean win;
        int count;

        public Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

     class Solution {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int[][] board;
        int minAnswer = Integer.MAX_VALUE;
        public int solution(int[][] board, int[] aloc, int[] bloc) {
            this.board = board;

            return dfs(aloc[0],aloc[1],bloc[0],bloc[1]).count;
        }

        private Result dfs(int y, int x, int cy, int cx) {
            if(board[y][x]==0) return new Result(false,0);

            boolean canWin = false;
            int minWin = Integer.MAX_VALUE;
            int maxLose = 0;

            for(int d=0;d<4;d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
                if (board[ny][nx] == 0) continue;
                board[y][x] = 0;
                Result result = dfs(cy, cx, ny, nx);
                board[y][x] = 1;

                if (result.win) {
                    maxLose = Math.max(maxLose, result.count+1);
                } else {
                    canWin = true;
                    minWin = Math.min(minWin, result.count+1);
                }
            }

            if(canWin){
                return new Result(true,minWin);
            }

            return new Result(false,maxLose);
        }


    }