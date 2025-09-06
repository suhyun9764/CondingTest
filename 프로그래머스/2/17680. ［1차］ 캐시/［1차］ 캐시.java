import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 메인 아이디어 : order(사용된 순서)이 낮을수록 큐의 맨앞에 위치 
        // Map을 사용하여 현재 캐시상태 관리
        // queue에서 Pop될때 map에서도 삭제
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i=0;i<cities.length;i++){
            String currentCity = cities[i].toLowerCase();
            if(cache.remove(currentCity)){
                cache.addLast(currentCity);
                answer++;
                continue;
            }
            
            if(cacheSize!=0&&cache.size()==cacheSize){
                cache.removeFirst();
            }
            
            if(cacheSize!=0){
                cache.addLast(currentCity);
            }
            
            answer+=5;
        }
        
        return answer;
    }
}