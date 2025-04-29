import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
        static int[] FIRST  = {1, 2, 3, 4, 5};
        static int[] SECOND = {2, 1, 2, 3, 2, 4, 2, 5};
        static int[] THIRD = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        static List<int[]> studentList = List.of(FIRST,SECOND,THIRD);
        int[] count = new int[3];

        public int[] solution(int[] answers) {
            dfs(0,count,answers);
            int max = 0;
            for (int i : count) {
                max =Math.max(i,max);
            }

            List<Integer> list = new ArrayList<>();
            for(int i=0;i<3;i++){
                if(count[i]==max)
                    list.add(i);
            }
            int[] answer = new int[list.size()];

            for(int i=0;i<answer.length;i++){
                answer[i] = list.get(i)+1;
            }

            return answer;

        }

        private void dfs(int problemNumber, int[] count, int[] answers) {
            if(problemNumber==answers.length)
                return;


            int currentAnswer = answers[problemNumber];
            for (int i=0;i<studentList.size();i++) {
                int[] studentAnswers = studentList.get(i);
                if(currentAnswer==studentAnswers[problemNumber%studentAnswers.length])
                    count[i]++;
            }

            dfs(problemNumber+1,count,answers);
        }
    }