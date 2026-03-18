import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<completion.length;i++){
            map.put(completion[i],map.getOrDefault(completion[i],0)+1);
        }
        
        String answer = null;
        for(int i=0;i<participant.length;i++){
            String cur = participant[i];
            if(!map.containsKey(cur)){
                answer = cur;
                break;
            }
            if(map.containsKey(cur)&&map.get(cur)==0){
                answer = cur;
                break;
            }
            
            map.put(cur,map.get(cur)-1);
        }
        
        return answer;
    }
}