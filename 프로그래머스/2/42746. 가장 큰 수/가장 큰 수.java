import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // numbers String으로 변환
        String[] strArray = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strArray[i] = String.valueOf(numbers[i]);
        }
        // String 배열을 (a+b) vs (b+a) 비교해서 정렬
        Arrays.sort(strArray,(a,b)->(b+a).compareTo(a+b));
        // 이어붙히기
        StringBuilder sb = new StringBuilder();
        for(String str : strArray){
            sb.append(str);
        }
        
        if(sb.toString().charAt(0)=='0')
            return "0";
        
        return sb.toString();
    }
}