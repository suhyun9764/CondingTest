import java.util.*;

class Solution {
        public int solution(String str1, String str2) {
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            Map<String,Integer> first = new HashMap<>();

            int firstCnt = 0;
            for(int i=0;i<str1.length()-1;i++){
                char firstChar = str1.charAt(i);
                char secondChar = str1.charAt(i + 1);

                if(!Character.isLetter(firstChar)||!Character.isLetter(secondChar)) continue;
                firstCnt++;
                String value = str1.substring(i, i + 2);
                first.put(value,first.getOrDefault(value,0)+1);
            }

            int secondCnt = 0;
            int bothCnt = 0;
            for(int i=0;i<str2.length()-1;i++){
                char firstChar = str2.charAt(i);
                char secondChar = str2.charAt(i + 1);

                if(!Character.isLetter(firstChar)||!Character.isLetter(secondChar)) continue;
                String value = str2.substring(i, i + 2);
                secondCnt++;
                if(first.containsKey(value)&&first.get(value)>0){
                    bothCnt++;
                    first.put(value,first.get(value)-1);
                }
            }
            double rate;
            if(firstCnt==0&&secondCnt==0)
                rate = 1;
            else{
                rate = (double) bothCnt/(firstCnt+secondCnt-bothCnt);
            }
            rate*=65536;

            return (int)rate;


        }
    }