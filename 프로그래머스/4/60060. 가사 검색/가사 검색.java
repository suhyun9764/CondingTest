import java.util.*;

class Solution {
        public int[] solution(String[] words, String[] queries) {
            // 원래단어 -> 크기에 따라, 크기가 같으면 compareto에 따라 나열
            // 거꾸로뒤집어서 -> 크기에 따라, 크기가 같으면 compareto에 따라
            Map<Integer, List<String>> map = new HashMap<>();
            Map<Integer,List<String>> reverseMap = new HashMap<>();

            String[] reverse = Arrays.copyOf(words, words.length);
            for(int i=0;i< reverse.length;i++){
                StringBuilder sb = new StringBuilder(reverse[i]);
                reverse[i] = sb.reverse().toString();
            }

            for(int i=0;i<words.length;i++){
                String word = words[i];
                String reverseWord = reverse[i];

                map.putIfAbsent(word.length(),new ArrayList<>());
                map.get(word.length()).add(word);

                reverseMap.putIfAbsent(reverseWord.length(),new ArrayList<>());
                reverseMap.get(reverseWord.length()).add(reverseWord);
            }

            // ✅ 길이별 정렬 보장
            for (List<String> lst : map.values()) Collections.sort(lst);
            for (List<String> lst : reverseMap.values()) Collections.sort(lst);

            int[] answer = new int[queries.length];
            for(int i=0;i<queries.length;i++){
                String cur = queries[i];
                boolean isReverse = false;

                if(cur.startsWith("?")) isReverse = true;

                String target = cur.replace("?", "");
                if(isReverse){
                    StringBuilder sb = new StringBuilder(target);
                    target = sb.reverse().toString();
                }
                int targetLength = cur.length();

                // 길이가 같아지는 시작점 구하기
                List<String> compareWords = map.get(targetLength);
                if(isReverse)
                    compareWords = reverseMap.get(targetLength);


//                int start = getSameLengthStart(targetLength,compareWords);
                // target으로 시작하는 시작점 구하기
                if(compareWords==null){
                    answer[i] = 0;
                    continue;
                }
                int sameStart = getSameStart(target,compareWords);
                int sameEnd = getSameEnd(target,compareWords);
//                int cnt = 0;
//                for(int t= sameStart;t<sameEnd;t++){
//                    String curWord = compareWords.get(t);
//                    int curWordLength = curWord.length();
//                    if(!curWord.startsWith(target)) break;
//                    if(curWordLength !=targetLength) continue;
//                    cnt++;
//                }

                answer[i] = sameEnd-sameStart;
            }
            return answer;
        }


        private int getSameEnd(String target, List<String> words) {
            int start = 0;
            int end = words.size();
            target = target+"{";

            while (start<end){
                int mid = (start+end)/2;

                if(words.get(mid).compareTo(target)>=0){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }

            return start;
        }



        private int getSameStart(String target, List<String> words) {
            int start = 0;
            int end = words.size();

            while (start<end){
                int mid = (start+end)/2;

                if(words.get(mid).compareTo(target)>=0){
                    end = mid;
                }else{
                    start =mid+1;
                }
            }
            return start;
        }
    }