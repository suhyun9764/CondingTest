import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int max = 0;
        for(int i=1;i<=citations.length;i++){
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i){
                    int underNum = j;
                    int upNum = citations.length-underNum;
                    if(underNum<=i&&upNum>=i){
                        answer = Math.max(answer, i);
                    }
                }
                
            }
        }
        
        return answer;
    }
}