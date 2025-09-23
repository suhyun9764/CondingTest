import java.util.*;

class Combination{
        String combination;
        int cnt;

        public Combination(String combination, int cnt) {
            this.combination = combination;
            this.cnt = cnt;
        }
    }
      class Solution {


        public String[] solution(String[] orders, int[] course) {
            List<String> answers = new ArrayList<>();
                       for(int i=0;i<orders.length;i++){
                String cur = orders[i];
                char[] charArray = cur.toCharArray();
                Arrays.sort(charArray);
                StringBuilder sb = new StringBuilder();
                for(char c : charArray){
                    sb.append(c);
                }

                orders[i] = sb.toString();
            }
            for(int target : course){
                List<Combination> list = new ArrayList<>();
                Map<String,Integer> map = new HashMap();
                for(String order : orders){
                    comb(order,target, map);
                }

                for(Map.Entry<String, Integer> combination : map.entrySet()){
                    list.add(new Combination(combination.getKey(),combination.getValue()));
                }

                Collections.sort(list,(a,b)->{
                    if(a.cnt==b.cnt)
                        return a.combination.compareTo(b.combination);

                    return b.cnt-a.cnt;
                });

                if(list.isEmpty()) continue;
                Combination max = list.get(0);
                         if(max.cnt<2)
                    continue;
                answers.add(max.combination);
                for(int i=1;i<list.size();i++){
                    if(list.get(i).cnt==max.cnt)
                        answers.add(list.get(i).combination);
                }
            }
            String[] answer = new String[answers.size()];
            for(int i=0;i<answers.size();i++){
                answer[i] = answers.get(i);
            }

            Arrays.sort(answer);

            return answer;
        }
        
        private void comb(String order, int n, Map<String,Integer> map) {
            char[] charArray = order.toCharArray();
            for(int i=0;i<order.length()-n+1;i++){
                dfs(i,1,n,map,charArray,String.valueOf(charArray[i]));
            }
        }

        private void dfs(int i, int length, int n, Map<String, Integer> map, char[] charArray, String str) {
            if(length==n)
                map.put(str,map.getOrDefault(str,0)+1);

            for(int j=i+1;j<charArray.length;j++) {
                dfs(j, length + 1, n, map, charArray, str + charArray[j]);
            }
        }
    }