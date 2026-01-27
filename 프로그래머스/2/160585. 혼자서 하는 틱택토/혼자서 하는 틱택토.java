import java.util.*;

class Solution {
    String[] board;
    int oNum = 0;
    int xNum = 0;
    public int solution(String[] board) {
        this.board = board;
        // 1. 갯수 비교 (x가 o보다 많을 수 없음)
        // 2. o나 x가 둘다 우승할 수 없음
        
        if(!isValidNum()) return 0;
        if(!isNotTwoWin()) return 0;
        
        return 1;
    }
    
    private boolean isValidNum(){
        int x = 0;
        int o = 0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char cur = board[i].charAt(j);
                if(cur=='O') o++;
                if(cur=='X') x++;
            }    
        }
        
        xNum = x;
        oNum = o;
        if(x>o) return false;
        if(Math.abs(x-o)>1) return false;
        return true;
    }
    
    private boolean isNotTwoWin(){
        boolean oWin = isWin('O');
        if(oWin&&(xNum==oNum)){
            return false;
        }
        boolean xWin = isWin('X');
         if(xWin&&(xNum<oNum)){
             return false;
         }
        
        if(oWin&&xWin) return false;
        return true;
    
    }
    
    private boolean isWin(char c){
        // 가로
        for(int i=0;i<3;i++){
            boolean win = true;
            for(int j=0;j<3;j++){
                char cur = board[i].charAt(j);
                if(cur!=c){
                    win = false;
                    break;
                }
            }
            
            if(win) return true;
        }
        // 세로
        for(int i=0;i<3;i++){
            boolean win = true;
            for(int j=0;j<3;j++){
                char cur = board[j].charAt(i);
                if(cur!=c){
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        // 대각선
        boolean win = true;
        for(int i=0;i<3;i++){
            if(board[i].charAt(i)!=c){
                win = false;
                break;
            }
        }
        
        if(win) return true;
        
        win = true;
        for(int i=0;i<3;i++){
            if(board[i].charAt(2-i)!=c){
                win = false;
                break;
            }
        }
        
        if(win) return true;
        return false;
    }
}