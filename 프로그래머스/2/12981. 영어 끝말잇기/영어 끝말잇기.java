import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
        public int[] solution(int n, String[] words) {
            Set<String> set = new HashSet<>();
            int lastNumber = 0;
            char lastChar = words[0].charAt(0);
            for(int i=0;i<words.length;i++){
                String currentWord = words[i];
                if(set.contains(currentWord)) {
                    lastNumber = i + 1;
                    break;
                }

                if(currentWord.charAt(0)!=lastChar){
                    lastNumber = i + 1;
                    break;
                }
                set.add(currentWord);
                lastChar = currentWord.charAt(currentWord.length()-1);
            }

            if(lastNumber==0)
                return new int[]{0,0};

            int person = lastNumber%n;
            if(person==0)
                person = n;

            int num;
            if(lastNumber%n==0){
                num = lastNumber/n;
            }else{
                num = lastNumber/n+1;
            }
            return new int[]{person,num};
        }
    }