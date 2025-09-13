import java.util.*;

class Solution {

        class Stage implements Comparable<Stage>{
            int num;
            double failRate;

            public Stage(int num, int cur, int pass){
                this.num = num;
                if(cur==0) {
                    failRate = 0;
                }else {
                    failRate = (double) cur /(cur+pass);
                }
            }

            public int compareTo(Stage o){
                if(o.failRate==this.failRate)
                    return this.num-o.num;

                return Double.compare(o.failRate,this.failRate);
            }
        }

        public int[] solution(int N, int[] stages) {
            // 0부터 N+1까지 구간합 배열 sumArr만들기
            // 0부터 N+1까지 현재 사용자들이 위치한 배열 arr만들기
            // stages 순회하며 구간합 배열 arr에 저장
            // 구간합 적용
            // arr순회하며 전체구간합-(현재스테이지 -1)

            int[] sumArr = new int[N+2];
            int[] arr = new int[N+2];

            for(int i=0;i<stages.length;i++){
                arr[stages[i]]++;
            }

            for(int i=1;i<N+2;i++){
                sumArr[i] = arr[i]+sumArr[i-1];
            }

            List<Stage> list = new ArrayList<>();
            int[] answer = new int[N];
            for(int i=1;i<=N;i++){
                list.add(new Stage(i,arr[i],sumArr[N+1]-sumArr[i]));
            }

            Collections.sort(list);
            for(int i=0;i<N;i++){
                answer[i] = list.get(i).num;
            }

            return answer;
        }
    }