import java.util.HashSet;
import java.util.Set;

class Solution {
        int count;
        public int solution(String begin, String target, String[] words) {
            count = words.length;
            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(word);
            }
            if(!set.contains(target))
                return 0;

            dfs(begin,target,words,0,set);
            return count;
        }

        private void dfs(String current, String target, String[] words, int depth, Set set) {
            if(current.equals(target)){
                count = Math.min(count,depth);
                return;
            }

            for(int i=0;i<words.length;i++){
                String thisWord = words[i];
                if(!set.contains(thisWord)) continue;
                if(compareWord(current,thisWord)==1){
                    set.remove(thisWord);
                    dfs(thisWord,target,words,depth+1,set);
                    set.add(thisWord);
                }
            }
        }

        private int compareWord(String current, String thisWord) {
            int count = 0;
            char[] currentArray = current.toCharArray();
            char[] thisArray = thisWord.toCharArray();

            for(int i=0;i<currentArray.length;i++){
                if(currentArray[i]!=thisArray[i])
                    count++;
            }

            return count;
        }
    }