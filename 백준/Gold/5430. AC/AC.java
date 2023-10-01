import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-->0){
            st = new StringTokenizer(br.readLine());
            char[] order = st.nextToken().toCharArray();
            st = new StringTokenizer(br.readLine());
            int arrSize = Integer.parseInt(st.nextToken());
            Deque<Integer> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            String bufString = st.nextToken();
            bufString = bufString.substring(1,bufString.length()-1);
            String[] split = bufString.split(",");
            String[] bufArr = new String[arrSize];
            for(int i=0;i<arrSize;i++){
                bufArr[i] = split[i];
            }

            for(int i=0;i<bufArr.length;i++){
                queue.add(Integer.parseInt(bufArr[i]));
            }
            List<Integer> answer = doOrder(order,queue);
            if(answer.size()==1) {
                if(answer.get(0)==-1)
                    System.out.println("error");
                else {
                    System.out.print("[");
                    System.out.print(answer.get(0));
                    System.out.println("]");
                }
            }
            else {
                int size = answer.size();
                System.out.print("[");
                for(int i=0;i<size;i++){
                    if(i<size-1)
                        System.out.print(answer.get(i)+",");
                    else
                        System.out.print(answer.get(i));
                }
                System.out.println("]");
            }
         }
    }

    private static List<Integer> doOrder(char[] order, Deque<Integer> queue) {
        List<Integer> answer = new ArrayList<>();
        Boolean flip = false;
        for(int i=0;i<order.length;i++){
            switch (order[i]){
                case 'R':
                    flip = !flip;
                    break;
                case 'D':
                    if(queue.size()==0) {
                        answer.clear();
                        answer.add(-1);
                        return answer;
                    }
                    if(flip)
                        queue.pollLast();
                    else
                        queue.pollFirst();
            }
        }

        int ansSize = queue.size();
        if(flip){
            for (int i = 0; i < ansSize; i++)
                answer.add(queue.pollLast());

            return answer;
        }else {
            for (int i = 0; i < ansSize; i++)
                answer.add(queue.poll());

            return answer;
        }
    }
}
