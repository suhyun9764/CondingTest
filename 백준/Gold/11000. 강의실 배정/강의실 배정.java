import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<int[]> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t= Integer.parseInt(st.nextToken());
            ls.add(new int[]{s,t});
        }
        ls.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];

                return o1[0] - o2[0];
            }
        });

        int ans = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int[] lecture : ls) {
            if(queue.isEmpty()){
                queue.add(lecture[1]);
            }
            else{
                while (queue.peek()<=lecture[0]){
                    queue.poll();
                }
                queue.add(lecture[1]);
            }

            if(ans<queue.size())
                ans = queue.size();
        }

        System.out.println(ans);
    }
}
