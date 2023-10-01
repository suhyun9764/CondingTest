import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Integer> queue;
    static LinkedList<Integer> list;
    static ListIterator<Integer> iterator;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st .nextToken());
        queue = new LinkedList<>();
        list = new LinkedList<>();
        iterator = list.listIterator();
        answer = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                executeOrder(order,value);
            }
            else
                excuteOrder(order);

        }
        for(int data : answer){
            System.out.println(data);
        }
    }

    private static void excuteOrder(String order) {

        switch (order){
            case "pop_front":
                if(queue.size()==0)
                    answer.add(-1);
                else
                    answer.add(queue.poll());

                break;
            case "pop_back":
                if(queue.size()==0)
                    answer.add(-1);
                else {
                    int num = list.get(list.size()-1);
                    answer.add(num);
                    list.removeLast();
                    queue = list;
                }
                break;

            case "size":
                answer.add(queue.size());
                break;
            case "empty":
                if(queue.size()==0)
                    answer.add(1);
                else
                    answer.add(0);
                break;
            case "front":
                if(queue.size()==0)
                    answer.add(-1);
                else
                    answer.add(queue.peek());
                break;
            case "back":
                if(queue.size()==0)
                    answer.add(-1);
                else {
                    int num = list.get(list.size()-1);
                    answer.add(num);
                }
                break;
        }
    }

    private static void executeOrder(String order, int value) {
        while (iterator.hasPrevious())
            iterator.previous();

        switch (order){
            case "push_back":
                list.add(value);
                queue = list;
                break;

            case "push_front" :
                list.addFirst(value);
                queue = list;
                break;


        }
    }
}
