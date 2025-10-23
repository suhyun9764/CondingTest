import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int n = number.length();
        for(int i=0;i<n;i++){
            char cur = number.charAt(i);
            if(stack.isEmpty()){
                stack.push(cur);
                continue;
            }
            
            
            while(!stack.isEmpty()&&k>0&&stack.peek()<cur){
                stack.pop();
                k--;
            }
            
            stack.push(cur);
        }
        
         while (k > 0) {
            stack.pop();
            k--;
        }
        
        char[] answerArr = new char[stack.size()];
        for(int i=answerArr.length-1;i>=0;i--){
            answerArr[i] = stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answerArr.length;i++){
            sb.append(answerArr[i]);
        }
        return sb.toString();
    }
}