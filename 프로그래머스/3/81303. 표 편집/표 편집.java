import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
        public String solution(int n, int k, String[] cmd) {
            Deque<Integer> inRangeStack = new ArrayDeque<>();   // 커서 포함 위쪽
            Deque<Integer> outRangeStack = new ArrayDeque<>();  // 커서 밑쪽
            Deque<Integer> deleteStack = new ArrayDeque<>();    // 삭제된 로그
            boolean[] isDeleted = new boolean[n];   // 삭제돤 행 체크

            // 현재 커서기준으로 위쪽 아랫쪽 채우기
            for (int i = 0; i < k+1 ; i++) {   
                inRangeStack.push(i);
            }

            for (int i = n; i > k; i--) {
                outRangeStack.push(i);
            }

            for (String str : cmd) {
                String[] orderAndNumber = str.split(" ");
                if (orderAndNumber[0].equals("U")) {
                    int number = Integer.parseInt(orderAndNumber[1]);
                    for (int i = 0; i < number; i++) {
                        // 만약 위쪽 행이 삭제된 항목일 경우 카운트에 포함하지 않고 넘기기
                        while (!inRangeStack.isEmpty()&&isDeleted[inRangeStack.peek()]){
                            outRangeStack.push(inRangeStack.pop());
                        }
                        // 현재 커서가 최상단일 경우 
                        if (inRangeStack.isEmpty())
                            break;

                        outRangeStack.push(inRangeStack.pop());
                        k--;
                    }
                }
                if (orderAndNumber[0].equals("D")) {
                    int number = Integer.parseInt(orderAndNumber[1]);
                    for (int i = 0; i < number; i++) {
                        while (!outRangeStack.isEmpty()&&isDeleted[outRangeStack.peek()]){
                            inRangeStack.push(outRangeStack.pop());
                        }
                        if (outRangeStack.isEmpty())
                            break;
                        inRangeStack.push(outRangeStack.pop());
                        k++;
                    }
                }
                if (orderAndNumber[0].equals("C")) {
                    isDeleted[k] = true;
                    deleteStack.push(k);
                }
                if (orderAndNumber[0].equals("Z")) {
                    int latestDelete = deleteStack.pop();
                    isDeleted[latestDelete] = false;
                }
            }

            StringBuilder answer = new StringBuilder();
            for (boolean b : isDeleted) {
                if(b){
                    answer.append("X");
                }else{
                    answer.append("O");
                }
            }
            return answer.toString();
        }
    }