import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int val = Integer.parseInt(br.readLine());
            queue.add(val);
        }

        int answer = 0;
        while (!queue.isEmpty()){
            int before = queue.poll();
            if(queue.isEmpty()){
                break;
            }
            int next = queue.poll();

            answer += next+before;

            if(queue.isEmpty())
                break;
            queue.add(before+next);
        }

        System.out.println(answer);

    }
}
