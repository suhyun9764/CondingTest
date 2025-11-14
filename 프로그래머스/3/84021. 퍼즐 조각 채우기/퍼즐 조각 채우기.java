import java.util.*;

class Solution {
    int gn, tn;
    int[][] gameBoard,table;
    boolean[][] boardVisit, tableVisit;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    public int solution(int[][] game_board, int[][] table) {
        this.gameBoard = game_board;
        this.table = table;
        this.gn = gameBoard.length;
        this.tn = table.length;
        this.boardVisit = new boolean[gn][gn];
        this.tableVisit = new boolean[tn][tn];
        int answer = 0;
        
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> puzzles = new ArrayList<>();
        
        // 게임 보드에서 빈칸 추출(정규화)
        for(int i=0;i<gn;i++){
            for(int j=0;j<gn;j++){
                if(gameBoard[i][j]==1) continue;
                if(boardVisit[i][j]) continue;
                List<int[]> result = extractFromGameBoard(i,j);
                result = normalized(result);
                blanks.add(result);
            }
        }
        
        // 테이블에서 퍼즐 조각 추출(정규화)
        for(int i=0;i<tn;i++){
            for(int j=0;j<tn;j++){
                if(table[i][j]==0) continue;
                if(tableVisit[i][j]) continue;
                List<int[]> result = extractFromTable(i,j);
                result = normalized(result);
                puzzles.add(result);
            }
        }
    
        // 퍼즐 돌려가며 빈칸과 매칭되는지 확인
        // 매칭된다면 answer+=칸의수
        boolean[] used = new boolean[puzzles.size()];
        for(List<int[]> blank : blanks){
            for(int i=0;i<puzzles.size();i++){
                if(used[i]) continue;
                if(blank.size()!=puzzles.get(i).size()) continue;
                boolean find = false;
                List<int[]> curPuzzle = puzzles.get(i);
                for(int r=0;r<4;r++){
                    curPuzzle = turn(curPuzzle);
                    if(isMatch(blank,curPuzzle)){
                        answer+=blank.size();
                        find = true;
                        used[i] = true;
                        break;
                    }
                }
                
                if(find) break;
            }
        }
        
        return answer;
        
    }
    
    private List<int[]> extractFromGameBoard(int y,int x){
        List<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        boardVisit[y][x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            result.add(cur);
            for(int d=0;d<4;d++){
                int ny = cur[0]+dy[d];
                int nx = cur[1]+dx[d];
                
                if(ny<0||ny>=gn||nx<0||nx>=gn) continue;
                if(boardVisit[ny][nx]) continue;
                if(gameBoard[ny][nx]==1) continue;
 
                boardVisit[ny][nx] = true;
                int[] cn = {ny,nx};
                queue.add(cn);
            }
        }
        return result;
    }
    
        
    private List<int[]> extractFromTable(int y,int x){
        List<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        tableVisit[y][x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            result.add(cur);
            for(int d=0;d<4;d++){
                int ny = cur[0]+dy[d];
                int nx = cur[1]+dx[d];
                
                if(ny<0||ny>=tn||nx<0||nx>=tn) continue;
                if(tableVisit[ny][nx]) continue;
                if(table[ny][nx]==0) continue;
 
                tableVisit[ny][nx] = true;
                int[] cn = {ny,nx};
                queue.add(cn);
            }
        }
        return result;
    }
    
    private List<int[]> normalized(List<int[]> result){
        int yMin = Integer.MAX_VALUE;
        int xMin = Integer.MAX_VALUE;
        
        List<int[]> nResult = new ArrayList<>();
        for(int[] r : result){
            yMin = Math.min(yMin,r[0]);
            xMin = Math.min(xMin,r[1]);
        }
        //   System.out.println("ymin : "+yMin);
        // System.out.println("xmin : "+xMin);
    
        for(int[] r: result){
            int ny = r[0] - yMin;
            int nx = r[1] - xMin;
                   // System.out.println("ny : "+ny);
        // System.out.println("nx : "+nx);
            // r = new int[]{ny,nx};
            nResult.add(new int[]{ny,nx});
        }
        
        // for(int[] r : nResult){
        //     System.out.println(Arrays.toString(r));
        // }
        // System.out.println();
        Collections.sort(nResult,(a,b)->{
           if(a[0]==b[0])
               return a[1]-b[1];
            
            return a[0]-b[0];
        });
        
        return nResult;
    }
    
    private boolean isMatch(List<int[]> blank, List<int[]> puzzle){
        for(int i=0;i<blank.size();i++){
            int[] curB = blank.get(i);
            int[] curP = puzzle.get(i);
            
            if(curB[0]!=curP[0]||curB[1]!=curP[1]) return false;
        }
        
        return true;
    }
    
    private List<int[]> turn(List<int[]> puzzle){
    List<int[]> rotated = new ArrayList<>();
    
    for(int[] p : puzzle){
        int y = p[0];
        int x = p[1];
        
        // 90도 회전
        int ny = x;
        int nx = -y;
        
        rotated.add(new int[]{ny, nx});
    }
    
    // 회전 후 정규화
    return normalized(rotated);
}

}