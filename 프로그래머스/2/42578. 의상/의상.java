import java.util.*;
class Solution {
    static Map<String,Integer> map;
    static List<String> categories;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        
        for(String[] c : clothes){
            String name = c[0];
            String category = c[1];
            if(map.containsKey(category)){
                map.put(category,map.get(category)+1);
            }else{
                map.put(category,1);
            }
        }
        int answer = 1;
        // 옷의 경우의 수
        for(int value : map.values()){
            answer *= value+1;
        }
        
        return answer-1;
    }
    
}