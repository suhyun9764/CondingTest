
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static int answer = 0;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static Set<Character> set = new HashSet<>();
    static boolean[] visit = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
//        set.add(board[0][0]);
        visit[board[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(answer);

    }

    private static void dfs(int y, int x, int cnt) {
        answer = Math.max(answer,cnt);
        List<int[]> list = new ArrayList<>();
        for(int d=0;d<4;d++){
            int ny = y+dy[d];
            int nx = x+dx[d];

            if(ny<0||nx<0||ny>=R||nx>=C) continue;
//            if(!set.contains(board[ny][nx])){
            char currentAlphabet = board[ny][nx];
            if(!visit[board[ny][nx]-'A']){
                visit[currentAlphabet-'A'] = true;
                dfs(ny,nx,cnt+1);
//            set.remove(currentAlphabet);
                visit[currentAlphabet-'A'] = false;
            }
        }

        if(list.isEmpty())
            return;

        for (int[] pos : list) {
            char currentAlphabet = board[pos[0]][pos[1]];
//            set.add(currentAlphabet);
            visit[currentAlphabet-'A'] = true;
            dfs(pos[0],pos[1],cnt+1);
//            set.remove(currentAlphabet);
            visit[currentAlphabet-'A'] = false;
        }
    }
}
