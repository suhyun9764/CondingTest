import java.util.*;

class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i=0;i<progresses.length;i++){
                // 1. 각 작업이 걸리는 기간을 progrsses에 업데이트
                progresses[i] = calculateCompleteDay(progresses[i],speeds[i]);
                // 2. 각 작업을 큐에 저장
                queue.offer(progresses[i]);
            }
            // 3. 큐가 비기전까지 반복
            List<Integer> answerList = new ArrayList<>();
            while (!queue.isEmpty()){
                // 4. 첫번째꺼를 꺼냈을 때 자기보다 작거나 같다면 poll 후 cnt ++
                int cnt = 0;
                int todayFirstProgress = queue.poll();
                cnt++;
                while (!queue.isEmpty()&&queue.peek()<=todayFirstProgress){
                    queue.poll();
                    cnt++;
                }
                answerList.add(cnt);
            }
            int[] answer = new int[answerList.size()];
            for(int i=0;i<answer.length;i++){
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        private int calculateCompleteDay(int progress, int speed) {
            int remain = 100-progress;
            if(remain%speed==0)
                return remain/speed;

            return remain/speed+1;
        }
    }