import java.util.*;

class Solution {
    int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {
        makeBoard(rows,columns);
        int n = queries.length;
        int[] answer = new int[n];
  
        for(int i=0;i<n;i++){
            answer[i] = execQuery(queries[i]);
        }
        
        return answer;
    }
    
    private void makeBoard(int rows, int columns){
        board = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                board[i][j] = (i*columns)+(j+1);
            }
        }
    }
    
    private int execQuery(int[] query){
        int y1 = query[0]-1;
        int x1 = query[1]-1;
        int y2 = query[2]-1;
        int x2 = query[3]-1;
        
        int nextX = x1+1;
        int nextY = y1;
        int temp = board[y1][x1];
        int min = temp;
        while(!(nextX==x1&&nextY==y1)){
            // System.out.println(cur);
            int cur = temp;
            min = Math.min(cur,min);
            temp  = board[nextY][nextX];
            board[nextY][nextX] = cur;
            
            if(nextY==y1){
                if(nextX==x2){
                    nextY++;
                }else{
                    nextX++;
                }
                continue;
            }
            
            if(nextY==y2){
                if(nextX==x1)
                    nextY--;
                else
                    nextX--;
                continue;
            }
            
            if(nextX==x1){
                nextY--;
                continue;
            }
            
            if(nextX==x2){
                nextY++;
            }
        }
        board[y1][x1] = temp;
        min = Math.min(temp,min);
        // for(int i=0;i<board.length;i++){
        //     System.out.println(Arrays.toString(board[i]));
        // }
        //         System.out.println();
        return min;
        
    }
}