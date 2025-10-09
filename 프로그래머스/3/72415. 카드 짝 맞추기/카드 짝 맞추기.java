import java.util.*;

class Solution {
    int[][] board;
    int r,c;
    int answer = Integer.MAX_VALUE;
    List<Integer> cardNumbers = new ArrayList<>();
    Map<Integer,List<int[]>> cards = new HashMap<>();
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    public int solution(int[][] board, int r, int c) {
        this.board = board;
        this.r = r;
        this.c = c;
        // 입력 횟수 : 현재 커서에서 카드까지의 입력 + 카드에서 같은 카드까지의 입력 + 2(enter)
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int cur = board[i][j];
                if(cur==0) continue;
                if(!cards.containsKey(cur)){
                    cardNumbers.add(cur);
                    cards.put(cur,new ArrayList<>());
                }
                cards.get(cur).add(new int[]{i,j});
            }
        }
        
        int cardCnt = cardNumbers.size();
        cardOrderDfs(new int[cardCnt],0,new boolean[cardCnt]);
        return answer;
    }
    
    private void cardOrderDfs(int[] cardOrder, int depth, boolean[] visited){
        if(depth==cardOrder.length){
            calculate(cardOrder,r,c,0,0,board);
            return;
        }
        
        for(int i=0;i<cardOrder.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            cardOrder[depth] = i;
            cardOrderDfs(cardOrder,depth+1,visited);
            visited[i] = false;
            cardOrder[depth] = 0;
        }
    }
    
    private void calculate(int[] cardOrder,int r,int c,int depth,int total,int[][] board){
        if(depth==cardOrder.length){
            answer = Math.min(total,answer);
            return;
        }
    
        List<int[]> curCards = cards.get(cardNumbers.get(cardOrder[depth]));
        int[] card1 = curCards.get(0);
        int[] card2 = curCards.get(1);
        int[][] b1 = cloneBoard(board);
        int d1 = bfs(r,c,card1[0],card1[1],b1,0);
        b1[card1[0]][card1[1]] = 0;
        int d2 = bfs(card1[0],card1[1],card2[0],card2[1],b1,0);
        b1[card2[0]][card2[1]] = 0;
        calculate(cardOrder,card2[0],card2[1],depth+1,total+d1+d2+2,b1);

        // 2️⃣ card2 -> card1
        int[][] b2 = cloneBoard(board);
        int d3 = bfs(r,c,card2[0],card2[1],b2,0);
        b2[card2[0]][card2[1]] = 0;
        int d4 = bfs(card2[0],card2[1],card1[0],card1[1],b2,0);
        b2[card1[0]][card1[1]] = 0;
        calculate(cardOrder,card1[0],card1[1],depth+1,total+d3+d4+2,b2);
    }
    
    private int[][] cloneBoard(int[][] board){
        int[][] newBoard = new int[4][4];
        
        for(int i=0;i<newBoard.length;i++){
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }
    
    
    private int bfs(int r,int c, int r2, int c2, int[][] board,int total){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r,c,0});
        boolean[][] visited = new boolean[4][4];
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int order = cur[2];
            
            if(y==r2&&x==c2){
                return order;
            }
            
            for(int d=0;d<4;d++){
                int ny = y+dy[d];
                int nx = x+dx[d];
                
                if(ny<0||ny>=4||nx<0||nx>=4) continue;
                if(!visited[ny][nx]){
                         visited[ny][nx] = true;
                queue.add(new int[]{ny,nx,order+1}); 
                }
          
                
                int[] ctrl = getCtrl(y,x,d,board);
                if(visited[ctrl[0]][ctrl[1]]) continue;
                visited[ctrl[0]][ctrl[1]] = true;
                queue.add(new int[]{ctrl[0],ctrl[1],order+1});
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    private int[] getCtrl(int y,int x, int d, int[][] board){
        while(true){
            int ny = y+dy[d];
            int nx = x+dx[d];
            
            if(ny<0||ny>=4||nx<0||nx>=4) break;
            y = ny;
            x = nx;
            if(board[ny][nx]!=0) break;
        }
        
        return new int[]{y,x};
    }
    
    
} 