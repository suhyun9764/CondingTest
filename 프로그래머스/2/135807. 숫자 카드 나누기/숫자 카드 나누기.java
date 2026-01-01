import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // arrayA의 최대 공약수 구하기
        // arrayB의 최대 공약수 구하기
        
        // arrayA의 최대공약수로 B나눠보기
        // 반대로
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gcdA = getTotalGcd(arrayA);
        int gcdB = getTotalGcd(arrayB);
        
        int answer = 0;
        if(isValidGcd(gcdA,arrayB)){
            answer = Math.max(answer,gcdA);
        }
        
        if(isValidGcd(gcdB,arrayA)){
            answer = Math.max(answer,gcdB);
        }
        
        return answer;
    }
    
    private int getTotalGcd(int[] array){
        int gcd = array[0];
        
        for(int i=1;i<array.length;i++){
            gcd = getGcd(gcd,array[i]);
        }
        
        return gcd;
    }
    
    private int getGcd(int n1, int n2){
        while(n2>0){
            int temp = n1%n2;
            n1 = n2;
            n2 = temp;
        }
        
        return n1;
    }
    
    private boolean isValidGcd(int gcd, int[] array){
        for(int i=0;i<array.length;i++){
            if(array[i]%gcd==0)
                return false;
        }
        
        return true;
    }
    
}