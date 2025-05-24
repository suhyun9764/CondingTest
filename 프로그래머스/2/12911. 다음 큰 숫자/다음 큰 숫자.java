import java.util.*;
class Solution {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n);
        int current = n+1;
        
        int answer = 0;
        while(true){
            if(Integer.bitCount(current)==oneCount){
                answer = current;
                break;
            }
            current++;
        }
        
        return answer;
    }
}