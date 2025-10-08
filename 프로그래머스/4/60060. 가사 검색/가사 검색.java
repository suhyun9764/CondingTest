import java.util.*;

class Solution {
        public int[] solution(String[] words, String[] queries) {
            // map길이별 -> 모든 조합에 따른 map
//            Map<Integer,Map<String,Integer>> lengthMap = new HashMap<>();
//
//            for(String word : words){
//                int length = word.length();
//                lengthMap.putIfAbsent(length,new HashMap<>());
//                Map<String, Integer> comb = lengthMap.get(length);
//                saveAllComb(word,0,length,new StringBuilder(),comb);
//            }
//
//            int[] answer = new int[queries.length];
//            for(int i=0;i<queries.length;i++){
//                String query = queries[i];
//                int queryLength = query.length();
//
//                if(!lengthMap.containsKey(queryLength)) continue;
//                Map<String, Integer> comb = lengthMap.get(queryLength);
//                if(!comb.containsKey(query)) continue;
//                answer[i] = comb.get(query);
//            }
//
//            return answer;
            Map<Integer,List<String>> wordMap = new HashMap<>();
            Map<Integer,List<String>> reverseWordMap = new HashMap<>();

            for(String word : words){
                int length = word.length();
                wordMap.putIfAbsent(length,new ArrayList<>());
                reverseWordMap.putIfAbsent(length,new ArrayList<>());
                wordMap.get(length).add(word);
                String reverseWord = reverse(word);
                reverseWordMap.get(length).add(reverseWord);
            }

            wordMap.values().stream().forEach(Collections::sort);
            reverseWordMap.values().stream().forEach(Collections::sort);
            int[] answer = new int[queries.length];
            for(int i=0;i<queries.length;i++){
                String query = queries[i];
                int length = query.length();
                Map<Integer,List<String>> map = wordMap;
                if(query.startsWith("?")){
                    query = reverse(query);
                    map = reverseWordMap;
                }
                query = getUnit(query);
                List<String> candidates = map.get(length);
                if(candidates==null){
                    answer[i] = 0;
                    continue;
                }
                if(query.length()==0){
                    answer[i] = candidates.size();
                    continue;
                }
                int start = findStart(query,candidates);
                        if(start>=candidates.size()) continue;
                if(!candidates.get(start).startsWith(query)) continue;
                int end = findEnd(query,candidates);
                answer[i] = end-start;

            }
            return answer;
        }

        private int findStart(String query, List<String> candidates) {
            int l = 0;
            int r = candidates.size();

            while (l<r){
                int mid = (l + r) / 2;
                if (candidates.get(mid).compareTo(query) >= 0)
                    r = mid;
                else
                    l = mid + 1;
            }

            return l;

        }

        private int findEnd(String query, List<String> candidates) {
            int l = 0;
            int r = candidates.size();
            char newC = (char) (query.charAt(query.length()-1)+1); StringBuilder sb = new StringBuilder(query); sb.setLength(query.length()-1); sb.append(newC); query = sb.toString();
            while (l<r){
                int mid = (l + r) / 2;
                if (candidates.get(mid).compareTo(query) > 0)
                    r = mid;
                else
                    l = mid + 1;
            }

            return l;
        }

        private String getUnit(String query) {
            int idx = query.indexOf('?');
            if (idx == -1) return query;
            return query.substring(0, idx);
        }

        private String reverse(String word) {
            StringBuilder sb = new StringBuilder();
            for(int i=word.length()-1;i>=0;i--) {
                sb.append(word.charAt(i));
            }

            return sb.toString();
        }

//        private void saveAllComb(String word, int depth, int N, StringBuilder sb, Map<String, Integer> comb) {
//            if(depth==N){
//                comb.put(sb.toString(),comb.getOrDefault(sb.toString(),0)+1);
//                return;
//            }
//
//            sb.append(word.charAt(depth));
//            saveAllComb(word,depth+1,N,sb,comb);
//            sb.setLength(depth);
//            sb.append("?");
//            saveAllComb(word,depth+1,N,sb,comb);
//        }
    }