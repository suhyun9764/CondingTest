import java.util.*;

class Solution {
        public int solution(int[] A, int[] B) {
            // B 큐에 저장
            Arrays.sort(B);
            Queue<Integer> queueB = new ArrayDeque<>();
            for(int i=0;i<B.length;i++){
                queueB.add(B[i]);
            }

            Queue<Integer> queueA = new ArrayDeque<>();
            // A 우선순위큐에 저장
            Arrays.sort(A);
            for(int i=0;i<A.length;i++){
                queueA.add(A[i]);
            }

            int answer = 0;

            while(!queueA.isEmpty()){
                boolean isBiggerExist = false;
                int currentA = queueA.poll();
                for(int i=0;i<queueB.size();i++){
                    int currentB = queueB.poll();
                    if(currentB>currentA){
                        answer++;
                        isBiggerExist = true;
                        break;
                    }
                    queueB.add(currentB);
                }
                if(!isBiggerExist) break;
            }
            return answer;
        }
    }