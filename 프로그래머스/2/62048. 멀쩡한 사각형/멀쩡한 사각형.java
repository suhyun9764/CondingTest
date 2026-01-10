import java.util.*;

class Solution {
    public long solution(int w, int h) {
       // 최소 공약수 구하기
        long gcd = getGcd(w,h);
        return (long)w*h-(w+h-gcd);
       
    }
    
    private long getGcd(int w,int h){
        long max = Math.max(w,h);
        long min = Math.min(w,h);
        
        while(min != 0){
            long r = max%min;
            max = min;
            min = r;
        }
        
        return max;
        
    }
}