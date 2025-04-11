
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] parents;
    static List<Integer>[] nodes;
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        Arrays.fill(parents,0);
        nodes = new List[N+1];
        for(int i=0;i<N+1;i++){
            nodes[i] = new ArrayList();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        parents[1] =1;
        queue.offer(1);
        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            List<Integer> myNodes = nodes[currentNode];
            for (Integer myNode : myNodes) {
                if(parents[myNode]==0){
                    parents[myNode] = currentNode;
                    queue.offer(myNode);
                }
            }
        }

        for(int i=2;i<N+1;i++){
            System.out.println(parents[i]);
        }
    }
}
