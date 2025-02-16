import java.util.ArrayDeque;
import java.util.Deque;


class Solution {
        public String solution(int n, int k, String[] cmd) {
            int[] prev = new int[n];
            int[] next = new int[n];
            int cursor = k;
            Deque<Integer> deleteStack = new ArrayDeque<>();

            for(int i=0;i<n;i++){
                prev[i] = i-1;
                next[i] = i+1;
            }

            next[n-1] = -1;

            for (String str : cmd) {
                String[] orderAndNumber = str.split(" ");
                if (orderAndNumber[0].equals("U")) {
                    int number = Integer.parseInt(orderAndNumber[1]);
                    for(int i=0;i<number;i++){
                        cursor = prev[cursor];
                    }
                }
                if (orderAndNumber[0].equals("D")) {
                    int number = Integer.parseInt(orderAndNumber[1]);
                    for(int i=0;i<number;i++){
                        cursor = next[cursor];
                    }
                }
                if (orderAndNumber[0].equals("C")) {
                    deleteStack.push(cursor);
                    int prevIndex = prev[cursor];
                    int nextIndex = next[cursor];

                    if(prevIndex!=-1) next[prevIndex] = nextIndex;
                    if(nextIndex!=-1) prev[nextIndex] = prevIndex;

                    if(nextIndex!=-1){
                        cursor=nextIndex;
                    }else{
                        cursor=prevIndex;
                    }
                }
                if (orderAndNumber[0].equals("Z")) {
                    int latestDelete = deleteStack.pop();
                    int prevIndex = prev[latestDelete];
                    int nextIndex = next[latestDelete];

                    if(prevIndex!=-1) next[prevIndex] = latestDelete;
                    if(nextIndex!=-1) prev[nextIndex] = latestDelete;
                }
            }

            StringBuilder answer = new StringBuilder("O".repeat(n));
            while (!deleteStack.isEmpty()){
                int currentDelete = deleteStack.pop();
                answer.setCharAt(currentDelete,'X');
            }

            return answer.toString();
        }
    }