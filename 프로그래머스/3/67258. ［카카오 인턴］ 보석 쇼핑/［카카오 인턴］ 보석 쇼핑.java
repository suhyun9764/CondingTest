import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        
        int totalNum = set.size();
        
        for(int i=0;i<totalNum;i++){
            map.put(gems[i],map.getOrDefault(gems[i],0)+1);
        }
        
        if(map.size()==totalNum)
            return new int[]{1,totalNum};
        
        int min = gems.length;
        int start = 0;
        int end = gems.length-1;
        
        int startIndex = 0;
        
        for(int i=totalNum;i<gems.length;i++){
            String currentGem = gems[i];
            map.put(currentGem, map.getOrDefault(currentGem,0)+1);
            
            while(map.get(gems[startIndex])>1){
                map.put(gems[startIndex], map.get(gems[startIndex])-1);
                startIndex++;
            }
            
            if(map.size()==totalNum){
                if(min>i-startIndex+1){
                    min = i-startIndex+1;
                    start = startIndex;
                    end = i;
                }else if(min == i-startIndex+1){
                    if(start>startIndex){
                        start = startIndex;
                        end = i;
                    }
                }
            }
        }
        
        return new int[]{start+1, end+1};
    }
}