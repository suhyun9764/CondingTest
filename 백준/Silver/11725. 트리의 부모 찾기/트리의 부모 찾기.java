import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
//    static boolean[][] board;
    static List[] lists;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        board = new boolean[N+1][N+1];
        lists = new List[N+1];
        for (int i=1;i<N+1;i++){
            lists[i] = new ArrayList();
        }
        parents = new int[N+1];
        Arrays.fill(parents,0);
        parents[1] = 1;
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            lists[n1].add(n2);
            lists[n2].add(n1);
//            board[n1][n2] = true;
//            board[n2][n1] = true;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int i=0;i<lists[current].size();i++){
                int node = (int) lists[current].get(i);
                if(parents[node]==0){
                    parents[node] = current;
                    queue.offer(node);
                }
            }
        }

        for(int i=2;i<N+1;i++){
            System.out.println(parents[i]);
        }
    }
}
