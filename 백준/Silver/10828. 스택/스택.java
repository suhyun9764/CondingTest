import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (st.hasMoreTokens()){
                int value = Integer.parseInt(st.nextToken());
                doOrder(order, value);
            }else
                doOrder(order);

        }
    }

    private static void doOrder(String order, int value) {
        stack.push(value);
    }

    private static void doOrder(String order) {
        switch (order){
            case "pop":
                if(stack.size()==0)
                    System.out.println(-1);
                
                else
                    System.out.println(stack.pop());
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                if(stack.size()==0)
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            case "top":
                if(stack.size()==0)
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
                break;
        }
    }
}
