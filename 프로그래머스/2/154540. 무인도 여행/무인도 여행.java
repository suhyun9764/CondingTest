import java.util.*;

class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    String[] maps;
    boolean[][] visit;
    int h,w;
    public int[] solution(String[] maps) {
        h= maps.length;
        w = maps[0].length();
        this.maps = maps;
        visit = new boolean[h][w];
        
        List<Integer> answerList = new ArrayList<>();

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(maps[i].charAt(j)=='X') continue;
                if(visit[i][j]) continue;
                visit[i][j] = true;
                answerList.add(dfs(i,j));
            }
        }
        
        Collections.sort(answerList);
        if(answerList.size()==0)
            return new int[]{-1};
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private int dfs(int y, int x){
        int day = (int)(maps[y].charAt(x)-'0');
        for(int d=0;d<4;d++){
            int ny = y+dy[d];
            int nx = x+dx[d];
            
            if(ny<0||nx<0||ny>=h||nx>=w) continue;
            if(maps[ny].charAt(nx)=='X') continue;
            if(visit[ny][nx]) continue;
            visit[ny][nx] = true;
            day += dfs(ny,nx);
        }
        return day;
    }
}