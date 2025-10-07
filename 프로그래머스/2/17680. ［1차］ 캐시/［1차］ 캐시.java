import java.util.*;
 class Solution {
        Map<String,Integer> cache;
        public int solution(int cacheSize, String[] cities) {
            cache = new HashMap<>();

            int total = 0;
            for(int i=0;i<cities.length;i++){
                String cur = cities[i].toLowerCase();
                if(cacheHit(cur)){
                    total+=1;
                    cache.put(cur,i);
                    continue;
                }
                if(cacheSize!=0&&cache.size()==cacheSize){
                    removeOldCache();
                }
                if(cacheSize!=0&&cache.size()<cacheSize)
                    cache.put(cur,i);
                total+=5;
            }
            return total;
        }

        private boolean cacheHit(String cur) {
            return cache.containsKey(cur);
        }

        private void removeOldCache() {
            int min = Integer.MAX_VALUE;
            String target = null;
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                String value = entry.getKey();
                int order = entry.getValue();
                if(min>order){
                    min = order;
                    target = value;
                }
            }

            cache.remove(target);
        }
    }