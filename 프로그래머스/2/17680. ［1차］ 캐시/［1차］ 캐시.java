import java.util.*;

class Solution {
        public int solution(int cacheSize, String[] cities) {
            List<String> list = new LinkedList<>();
            int answer = 0;
            int currentCacheSize = 0;
            if(cacheSize==0){
                return cities.length*5;
            }

            for(String originCity : cities){
                String city = originCity.toLowerCase();
                // 새로 들어온 경우
                if(list.contains(city)){
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).equals(city)){
                            list.add(list.remove(i));
                            break;
                        }
                    }
                    answer+=1;
                }
                // 이미 있는 경우
                else{
                    // 캐시가 남아있는 경우
                    if(currentCacheSize<cacheSize){
                        currentCacheSize++;
                    }else{// 캐시가 가득찬 경우
                        list.remove(0);
                    }
                    list.add(city);
                    answer+=5;
                }
            }
            
            return answer;
        }
    }