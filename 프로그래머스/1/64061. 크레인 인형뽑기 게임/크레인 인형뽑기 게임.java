import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
            int answer = 0;
            // 뽑은 인형을 담을 바구니
            Deque<Integer> basket = new ArrayDeque<>();
            // board를 스택 구조로 변경
            List<Deque<Integer>> boardStack = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                Deque<Integer> section = new ArrayDeque<>();
                for (int j = board.length - 1; j >= 0; j--) {
                    if (board[j][i] != 0)
                        section.push(board[j][i]);
                }
                boardStack.add(section);
            }

            // 모든 작동 순회
            for (int position : moves) {
                Deque<Integer> currentSection = boardStack.get(position-1);
                // 비어있지 않은 경우에만
                if (!currentSection.isEmpty()) {
                    int doll = currentSection.pop();
                    // 바구니 최상단에 있는거랑 같다면 둘다 제거
                    if(!basket.isEmpty()&&basket.peek()==doll){
                        basket.pop();
                        answer+=2;
                    }else{
                        basket.push(doll);
                    }
                }
            }
            return answer;
        }
}