import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer,Integer> leftMap = new HashMap<>();
        Map<Integer,Integer> rightMap = new HashMap<>();
        
        for(int eachTopping : topping){
            leftMap.put(eachTopping, leftMap.getOrDefault(eachTopping,0)+1);
        }
        
        int answer = 0;
        for(int i=0;i<topping.length;i++){
            int currentTopping = topping[i];
            rightMap.put(currentTopping, rightMap.getOrDefault(currentTopping,0)+1);
            leftMap.put(currentTopping, leftMap.get(currentTopping)-1);
            if(leftMap.get(currentTopping)==0)
                leftMap.remove(currentTopping);
            
            if(leftMap.size()==rightMap.size())
                answer++;
        }
        
        return answer;
    }
}