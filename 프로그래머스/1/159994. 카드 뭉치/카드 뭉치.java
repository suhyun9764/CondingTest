import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            // 1. 3 개의 배열 모두 큐에 담기
            Queue<String> card1Queue = new ArrayDeque<>();
            Queue<String> card2Queue = new ArrayDeque<>();
            Queue<String> goalQueue = new ArrayDeque<>();

            for (String card : cards1) {
                card1Queue.offer(card);
            }

            for (String card : cards2){
                card2Queue.offer(card);
            }

            for (String str : goal) {
                goalQueue.offer(str);
            }

            // 2. card1과 card2 둘중하나라도 남아있다면 루프
            while(!card1Queue.isEmpty()||!card2Queue.isEmpty()){
                // 5. goal이 없어지면 return true;
                if(goalQueue.isEmpty()) return "Yes";
                String currentGoal = goalQueue.peek();

                // 3. goal을 꺼내 cards1과 cards2에서 poll()을 했을때 해당 goal이 있다면 다음 루프
                if(!card1Queue.isEmpty()&&card1Queue.peek().equals(currentGoal)){
                    card1Queue.poll();
                    goalQueue.poll();
                }else if(!card2Queue.isEmpty()&&card2Queue.peek().equals(currentGoal)){
                    card2Queue.poll();
                    goalQueue.poll();
                }else{
                    // 4. 만약 없다면 return "No"
                    return "No";
                }
            }
            if(goalQueue.isEmpty())
                return "Yes";

            return "No";
        }
    }