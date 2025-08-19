import java.util.*;

class Solution {
        public int[] solution(int[] numbers) {
            Stack<N> stack = new Stack<>();
            Map<Integer,Integer> map = new HashMap<>();
            int[] answer = new int[numbers.length];
            
            for(int i=0;i<numbers.length;i++){
                N currentN = new N(i,numbers[i]);
                if(stack.isEmpty()){
                    stack.push(currentN);
                    continue;
                }
                
                while(!stack.isEmpty()){
                    int before = stack.peek().value; 
                    if(before >= currentN.value) break;
                    answer[stack.pop().index] = currentN.value;
                }
        
                stack.push(currentN);
            }
            
            while(!stack.isEmpty()){
                answer[stack.pop().index] = -1;
            }
            
           return answer;
            
        }
    
    class N{
        int index;
        int value;
        
        public N(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

}