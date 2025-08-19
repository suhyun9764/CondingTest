import java.util.*;

class Solution {
        public int solution(String str1, String str2) {
            // 1. str1 set에 저장
            // 요구사항 : 대소문자 구분 x, 특수문자 포함하면 해당 글자 쌍 버리기
            Map<String,Integer> str1Map = new HashMap<>();
            char[] str1CharArray = str1.toCharArray();
            Character before = null;
            int str1Count = 0;
            for(int i=0;i<str1CharArray.length;i++){
                if(before==null){
                    char current = str1CharArray[i];
                    if(!Character.isLetter(current)) continue;
                    current = Character.toLowerCase(current);
                    before = current;
                    continue;
                }

                Character current = str1CharArray[i];
                if(!Character.isLetter(current)){
                    before = null;
                    continue;
                }
                current = Character.toLowerCase(current);
                String comb = before.toString() + current.toString();
                str1Map.put(comb, str1Map.getOrDefault(comb,0)+1);
                str1Count++;
                before = current;
            }
            // 2. str2 set에 저장
            // 요구사항1 : 대소문자 구분 x, 특수문자 포함하면 해당 글자 쌍 버리기
            Map<String,Integer> str2Map = new HashMap();
            char[] str2CharArray = str2.toCharArray();
            Character before2 = null;
            int str2Count = 0;
            for(int i=0;i<str2CharArray.length;i++){
                if(before2==null){
                    char current = str2CharArray[i];
                    if(!Character.isLetter(current)) continue;
                    current = Character.toLowerCase(current);
                    before2 = current;
                    continue;
                }

                Character current = str2CharArray[i];
                if(!Character.isLetter(current)){
                    before2 = null;
                    continue;
                }
                current = Character.toLowerCase(current);
                String comb = before2.toString() + current.toString();
                str2Map.put(comb, str2Map.getOrDefault(comb,0)+1);
                str2Count++;
                before2 = current;
            }

            // 3. str2 map 순회하며 str1 set에 저장되어있는지 확인
            int both = 0;
            for (Map.Entry<String, Integer> str2Entry : str2Map.entrySet()) {
                String key = str2Entry.getKey();
                if(str1Map.containsKey(key))
                    both += Math.min(str1Map.get(key),str2Entry.getValue());
            }

            int sum = str1Count + str2Count-both;
            // 5. 합집합 갯수 구하기 : str1 map size + str2 map size - both
            float result;
            if(sum == 0) result = 1;
            else result = (float) both / sum;
            // 6. 자카드 유사도 계산
             return (int) ((int)65536*result);
        }
    }