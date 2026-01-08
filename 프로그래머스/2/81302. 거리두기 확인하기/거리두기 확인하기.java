import java.util.*;

class Solution {
    int[] answer;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int[] dy2 = {2,1,0,-1,-2,-1,0,1};
    int[] dx2 = {0,-1,-2,-1,0,1,2,1};
    String[] room;
    
    public int[] solution(String[][] places) {
        int n = places.length;
        answer = new int[n];
        
        for(int i=0;i<n;i++){
            room = places[i];
            if(isValid())
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        
        return answer;
    }
    
    private boolean isValid(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(room[i].charAt(j)=='P'){
                    if(validate1(i,j)&&validate2(i,j))
                        continue;
                    
                    return false;
                }
            }
        }
    
        return true;
    }
    
    private boolean validate1(int y,int x){
        // System.out.println(y+", "+x);
        for(int d=0;d<4;d++){
            int ny = y+dy[d];
            int nx = x+dx[d];
            
            if(ny<0||nx<0||ny>=5||nx>=5) continue;
            if(room[ny].charAt(nx)=='P') return false;
        }
        
        return true;
    }
    
    private boolean validate2(int y,int x){
        for(int d=0;d<8;d++){
            int ny = y+dy2[d];
            int nx = x+dx2[d];
            
            if(ny<0||nx<0||ny>=5||nx>=5) continue;
            if(room[ny].charAt(nx)!='P') continue;
            if(y==ny||x==nx){
                int avgX = (x+nx)/2;
                int avgY = (y+ny)/2;
                if(room[avgY].charAt(avgX)!='X') return false;
                continue;
            }
            
            if(room[y].charAt(nx)=='O'||room[ny].charAt(x)=='O') return false;
        }
        
        return true;
    }
    
}
