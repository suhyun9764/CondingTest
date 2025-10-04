class Solution {
        public int solution(int[][] board, int[][] skill) {
            int[][] memo = new int[board.length+1][board[0].length+1];

            for(int i=0;i<skill.length;i++){
                int action = skill[i][0];
                int y1 = skill[i][1];
                int x1 = skill[i][2];
                int y2 = skill[i][3];
                int x2 = skill[i][4];

                int dmg = skill[i][5];
                if(action==1)
                    dmg*=-1;

                memo[y1][x1] += dmg;
                memo[y1][x2+1] -= dmg;
                memo[y2+1][x1] -= dmg;
                memo[y2+1][x2+1] += dmg;
            }


            for(int i=0;i<memo.length;i++) {
                for (int j = 1; j < memo[0].length; j++) {
                    memo[i][j] += memo[i][j - 1];
                }
            }

            for(int i=0;i<memo[0].length;i++){
                for(int j=1;j<memo.length;j++){
                    memo[j][i] += memo[j-1][i];
                }
            }

            int answer = board.length*board[0].length;

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    memo[i][j]+=board[i][j];
                }
            }

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(memo[i][j]<=0) answer--;
                }
            }

            return answer;
        }
    }