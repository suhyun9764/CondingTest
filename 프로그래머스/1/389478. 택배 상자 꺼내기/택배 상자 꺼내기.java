class Solution {
        public int solution(int n, int w, int num) {
            /* 택배 상자 쌓기 (좌우 상하로 뒤집어서 생각)
            (1) 높이 0부터 놓기
            (2) 시작은 오른쪽으로
            (3) 해당줄이 홀수이면 해당줄은 왼쪽으로
             */
            int h;
            if (n % w == 0)
                h = n / w;
            else
                h = n / w + 1;

            int[][] boxes = new int[h][w];
            int boxIndex = 1;

            int targetY = 0;
            int targetX = 0;
            for (int i = 0; i < h; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < w; j++) {
                        if (boxIndex > n)
                            break;
                        boxes[i][j] = boxIndex++;
                        if (boxes[i][j] == num) {
                            targetY = i;
                            targetX = j;
                        }
                    }
                } else {
                    for (int j = w - 1; j >= 0; j--) {
                        if (boxIndex > n)
                            break;
                        boxes[i][j] = boxIndex++;
                        if (boxes[i][j] == num) {
                            targetY = i;
                            targetX = j;
                        }
                    }
                }
            }

            int answer = 1;

            for(int i=targetY+1;i<h;i++){
                if(boxes[i][targetX]!=0)
                    answer++;
            }

            return answer;
        }
    }