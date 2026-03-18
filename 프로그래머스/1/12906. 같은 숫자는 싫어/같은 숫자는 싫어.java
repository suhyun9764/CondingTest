import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> aq = new Stack<>();
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int cur = arr[i];
            if(aq.isEmpty()||aq.peek()!=cur){
                aq.push(cur);
                answerList.add(cur);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}