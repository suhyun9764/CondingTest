import java.util.*;

class Solution {

        public int[] solution(String[] info, String[] query) {
            // map에 가능한 모든 문자열 형태로 저장(점수)
            // map순회하며 각 리스트 모두 정렬
            // 해당 쿼리 조건에 맞는 map의 리스트에서 일정 이상점수가 몇개인지 구하기 (이분탐색)

            Map<String, List<Integer>> map = new HashMap<>();

            for(int i=0;i<info.length;i++){
                String[] curField = info[i].split(" ");
                saveToMap(curField,map);
            }

            for(List<Integer> list : map.values()){
                Collections.sort(list);
            }

            int[] answer = new int[query.length];
            for(int i=0;i<query.length;i++){
                String strQuery = getStrQuery(query[i]);
                int score = getScore(query[i]);
                List<Integer> list = map.getOrDefault(strQuery,new ArrayList<>());
                int startIndex = getMinOverScore(list,score);

                answer[i] = list.size()-startIndex;
            }

            return answer;
        }

        private void saveToMap(String[] curField, Map<String, List<Integer>> map) {
            StringBuilder sb =new StringBuilder();
            dfs(0,map,curField,new boolean[4]);
        }

        private void dfs(int i, Map<String, List<Integer>> map, String[] curField, boolean[] visit) {
            if(i==4) {
                StringBuilder sb = new StringBuilder();
                for(int b=0;b<4;b++){
                    if(visit[b]){
                        sb.append(curField[b]);
                        continue;
                    }

                    sb.append("-");
                }

                map.putIfAbsent(sb.toString(),new ArrayList<>());
                map.get(sb.toString()).add(Integer.valueOf(curField[4]));
                return;
            }

            visit[i] = true;
            dfs(i+1,map,curField,visit);
            visit[i] = false;
            dfs(i+1,map,curField,visit);
        }

        private String getStrQuery(String query) {
            String[] split = query.split(" and ");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<split.length;i++){
                if(i==split.length-1){
                    String str = split[i].split(" ")[0];
                    sb.append(str);
                    continue;
                }
                sb.append(split[i]);
            }
            return sb.toString();
        }

        private int getScore(String query) {
            String[] split = query.split(" and ");
            return Integer.parseInt(split[3].split(" ")[1]);
        }

        private int getMinOverScore(List<Integer> list, int score) {
            int start = 0;
            int end = list.size();

            while (start<end){
                int mid = (start+end)/2;

                if(list.get(mid)>=score)
                    end=mid;
                else
                    start=mid+1;
            }

            return start;
        }
    }