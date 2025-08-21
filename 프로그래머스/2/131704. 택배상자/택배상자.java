import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 보조 벨트인 stack 생성
        Stack<Integer> stack = new Stack<>();
        // 본 벨트의 현재박스 인덱스 생성
        int boxNumber = 1;
        // order 순회
        for(int i=0;i<order.length;i++){
            int currentOrder = order[i];
             // 현재박스의 인덱스가 currentOrder보다 작다면 stack에 push
            while(boxNumber < currentOrder){
                stack.push(boxNumber++);
            }
            
            // 현재박스의 인덱스가 i와 같다면 바로 컨베이어벨트에 올라가므로 answer ++
            if(currentOrder == boxNumber){
                answer++;
                boxNumber++;
                continue;
            }
            
            // 현재박스의 인덱스가 i보다 크다면 stack에서 pop 
            // 만약 pop한게 i와 같다면 answer ++;
            // 아니라면 break
            int stackBox = stack.pop();
            if(stackBox!=currentOrder)
                break;
            
            answer++;
        }
       return answer;
    }
}