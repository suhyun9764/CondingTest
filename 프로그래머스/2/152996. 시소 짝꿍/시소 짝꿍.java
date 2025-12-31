import java.util.*;

class Solution {
    public long solution(int[] weights) {
        // 정렬
        // Map에 저장
        // 자기랑 같거나 각 곱과 같다면 answer++;
        int[][] rates = new int[][]{{1,2},{2,3},{3,4}};
        int n = weights.length;
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(weights);
        for(int i=0;i<n;i++){
            int weight = weights[i];
            map.put(weight,map.getOrDefault(weight,0)+1);
        }
        
        long answer = 0;
        for(int i=0;i<n;i++){
            int cur = weights[i];
            if(set.contains(cur)) continue;
            set.add(cur);
            long curNum = map.get(cur);
            answer+=(curNum*(curNum-1))/2;
            for(int r=0;r<rates.length;r++){
                int[] rate = rates[r];
                if(cur*rate[1]%rate[0]==0){
                    answer+=(long)curNum*map.getOrDefault(cur*rate[1]/rate[0],0);
                }
            }
            
        }
        
        return answer;
    }
    
}