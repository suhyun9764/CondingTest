import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 1. n을 k진수로 변환 후 charArray로 변환
        char[] charArray = Integer.toString(n,k).toCharArray();
        // 2. charArray 순환
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i] == '0'){
                // 0이 나오면 소수판별 후 sb 초기화
                if(sb.length()>=1 && isSosoo(Long.parseLong(sb.toString()))){
                   answer++; 
                }
                sb.setLength(0);
            }
            else{
                sb.append(charArray[i]);
            }
            // 0이 나올때까지 sb.append

        }
        if(sb.length()>0){
            // 5. 만약 끝이나면 그대로 소수판별
             if(isSosoo(Long.parseLong(sb.toString()))){
                   answer++; 
                }
        }
        return answer;

    }
    
    private boolean isSosoo(Long target){
        if(target<2) return false;
        if(target==2) return true;
        
        if(target % 2 ==0) return false;
        
        for(int i=3;i<=Math.sqrt(target);i+=2){
            if(target%i==0) return false;
        }
        
        return true;
    }
}