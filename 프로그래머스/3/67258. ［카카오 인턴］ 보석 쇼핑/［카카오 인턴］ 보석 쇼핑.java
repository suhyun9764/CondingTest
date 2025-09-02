import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        
        int n = set.size();
        
        Map<String,Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        int min = gems.length;
        int answerLeft = 0;
        int answerRight = 0;
        
        for(int i=0;i<gems.length;i++){
            map.put(gems[i],map.getOrDefault(gems[i],0)+1);
            
            if(map.size()==n){
                while(map.get(gems[left])>=2){
                    map.put(gems[left],map.get(gems[left])-1);
                    left++;
                }
                 if(i-left<min){
                    min = i-left;
                    answerLeft = left;
                    answerRight = i;
                 }
            }
            
           
        }
        
        return new int[]{answerLeft+1,answerRight+1};
    }
}