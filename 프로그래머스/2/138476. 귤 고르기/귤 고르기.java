import java.util.*;

class Solution {
        public int solution(int k, int[] tangerine) {
            List<int[]> list = new ArrayList<>();
            Map<Integer,Integer> map = new HashMap<>();
            for(int t : tangerine){
                if(map.containsKey(t)){
                    list.get(map.get(t))[1]++;
            }else{
                list.add(new int[]{t,1});
                map.put(t,list.size()-1);
                }
            }
       
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });

            int answer =0;
            for(int i=0;i<list.size();i++){
                if(k<=0)
                    break;

                k-=list.get(i)[1];
                answer++;
            }

            return answer;
        }
    }