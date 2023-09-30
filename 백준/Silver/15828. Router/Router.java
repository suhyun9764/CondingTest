import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        while (true){
            int input = Integer.parseInt(br.readLine());
            // 0이 들어왔을 때(맨 앞 원소 제거)
            if(input==0)
                queue.poll();
            // -1이 들어왔을 때(break)
            else if(input==-1)
                break;
            // 나머지 수 들어왔을 때
            else
                if(queue.size()<n) // 버퍼 크기만큼만 입력 받기
                    queue.offer(input);
        }
        
        if(queue.size()==0)
            System.out.println("empty");
        else {
            while (queue.size() > 0)
                System.out.print(queue.poll() + " ");
        }
    }
}
