import java.util.*;

class Stage{
        int stageNumber;
        float rate;

         public Stage(int stageNumber,int tryCnt, int inCnt) {
            this.stageNumber = stageNumber;
            if(tryCnt==0)
                rate=0;
            else
                this.rate = (float) inCnt/tryCnt;
        }
    }
     class Solution {
        int N;
        int[] stages;
        public int[] solution(int N, int[] stages) {
            this.N = N;
            this.stages = stages;

            int[] inStage = new int[N+1];
            int[] tryCnt = new int[N+1];
            for(int i=0;i<stages.length;i++){
                int cur = stages[i];
                if(cur>N) {
                    for(int t=1;t<=N;t++){
                        tryCnt[t]++;
                    }
                    continue;
                }
                inStage[cur]++;
                for(int t=1;t<=cur;t++){
                    tryCnt[t]++;
                }
            }

            List<Stage> allStage = new ArrayList<>();
            for(int i=1;i<=N;i++){
                allStage.add(new Stage(i,tryCnt[i], inStage[i]));
            }

            allStage.sort((a, b) -> {
                if (a.rate == b.rate) {
                    return a.stageNumber - b.stageNumber;
                }

                return Float.compare(b.rate, a.rate);
            });

           return allStage.stream().mapToInt(a->a.stageNumber).toArray();
        }
    }