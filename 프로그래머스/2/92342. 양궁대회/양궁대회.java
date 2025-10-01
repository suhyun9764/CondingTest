import java.util.*;

class Solution {
        int[] apeaches = new int[11];
        int max = 0;
        int totalScore = 0;
        int[] answer;
        int n;
        public int[] solution(int n, int[] info) {
            this.n = n;
            // List에 어피치가 맞춘 점수들 정렬
            // List에서 조합한 값이 나머지 값들의 합보다 큰경우(라이언이 이기는 경우)를 모두 탐색
            List<Integer> apeachScore = new ArrayList<>();
            for(int i=0;i<info.length;i++){
                int cur = 10-i;
                if(info[i]==0) continue;
                apeachScore.add(cur);
                apeaches[10-i] = info[i];
            }

            dfs(0,10,new int[11]);
                if(answer==null)
                return new int[]{-1};
            int[] realAnswer = new int[answer.length];
            for(int i=0;i<realAnswer.length;i++){
                realAnswer[i] = answer[10-i];
            }

            return realAnswer;
        }

        private void dfs(int depth, int cur, int[] scores) {
//            if(cur==0){
//                int remain = n-depth;
//                scores[0] += remain;
//                depth = n;
//             }

            if(cur==-1){
                return;
            }
            if(depth==n) {
                int apeachTotal = 0;
                int lianTotal = 0;
                for(int i=0;i<=10;i++){
                    if(scores[i]==0&&apeaches[i]==0) continue;
                    if(scores[i]<=apeaches[i]) apeachTotal +=i;
                    if(scores[i]>apeaches[i]) lianTotal +=i;
                }

                if(lianTotal>apeachTotal){
                    int curTotal = getCurTotal(scores);
                    if(max<lianTotal-apeachTotal){
                        max = lianTotal-apeachTotal;
                        totalScore = curTotal;
                        answer = scores.clone();
                    }

                    if(max==lianTotal-apeachTotal){
                        if(totalScore> curTotal) {
                            totalScore = curTotal;
                            answer = scores.clone();
                        }
                    }
                }
                return;
            }

            scores[cur]++;
            dfs(depth+1,cur,scores);
            scores[cur]--;
            dfs(depth,cur-1,scores);

        }

        private static int getCurTotal(int[] scores) {
            int result = 0;
            for(int i=0;i<=10;i++){
                result +=i* scores[i];
            }
            return result;
        }
    }