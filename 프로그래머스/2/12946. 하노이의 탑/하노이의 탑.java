import java.util.*;

class Solution {
     List<int[]> move = new ArrayList<>();
    public int[][] solution(int n) {
        move.clear();
        hanoi(n,1,3,2);
        int[][] answer = new int[move.size()][2];
        for(int i=0;i<move.size();i++){
            answer[i] = move.get(i);
        }
    
        return answer;
    }
    
    private void hanoi(int n, int start, int to, int buf){
        if(n==1){
            move.add(new int[]{start,to});
            return;
        }
        hanoi(n-1,start,buf,to);
        move.add(new int[]{start,to});
        hanoi(n-1,buf,to,start);
    }
}