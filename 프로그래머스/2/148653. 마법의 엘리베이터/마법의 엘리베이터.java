import java.util.*;

class Solution {
    public int solution(int storey) {
        int current = storey;
        int answer = 0;
        while(true){
            if(current == 0)
                break;
            
            String str = String.valueOf(current);
            int c = 0;
            // 만약 current가 -로 시작된다면(음수라면)
            if(current<0){
                // 첫쨰자리 떼고 나머지 길이의 -1 = c; 더하기
                c = str.length()-2;
                current = Math.min(Math.abs(current+(int)Math.pow(10,c)),Math.abs(current+(int)Math.pow(10,c+1)));
                answer++;
                continue;
            }

            // 양수라면
            c = str.length()-1;
            current = Math.min(Math.abs(current-(int)Math.pow(10,c)),Math.abs(current-(int)Math.pow(10,c+1)));
            // 총길이의 -1 = c 빼기
            answer ++;
        }
        
        return answer;
    }
}