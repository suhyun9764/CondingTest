import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        dfs(begin, target, words, 0, new boolean[words.length]);
        if(answer==Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    private void dfs(String cur, String target, String[] words, int depth, boolean[] visit){
        if(cur.equals(target)){
            answer= Math.min(answer,depth);
            return;
        }
        // System.out.println(cur);
        for(int i=0;i<words.length;i++){
            if(visit[i]) continue;
            if(!isOneDiff(cur,words[i])) continue;
            visit[i] = true;
            dfs(words[i],target,words,depth+1,visit);
            visit[i] = false;
        }
    }
    
    private boolean isOneDiff(String s1, String s2){
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
            if(diff>1) return false;
        }
        
        return diff==1;
    }
}