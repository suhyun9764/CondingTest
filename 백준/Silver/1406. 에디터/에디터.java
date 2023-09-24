import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Main {
    static ListIterator<Character> iterator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] arr = st.nextToken().toCharArray();
        List<Character> list = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        iterator = list.listIterator();
        while (iterator.hasNext())
            iterator.next();
        for (int i = 0; i < m; i++) { // 총시간복잡도 : O(N)
            st = new StringTokenizer(br.readLine());
            char[] order = new char[st.countTokens()];
            for (int j = 0; j < order.length; j++) { // 시간복잡도 : O(N)
                order[j] = st.nextToken().charAt(0);
            }
            switch (order[0]){
                case 'L':
                    orderL();
                    break;
                case 'D':
                    orderD();
                    break;
                case 'B':
                    orderB();
                    break;
                case 'P':
                    orderP(order[1]);
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (iterator.hasPrevious())
            iterator.previous();
        while (iterator.hasNext())
            bw.write(iterator.next()+"");
        bw.flush();
    }

    private static void orderP(char c) { //시간복잡도 : O(1)
        iterator.add(c);
    }

    private static void orderB() { //시간복잡도 : O(1)
        if(iterator.hasPrevious()){
            iterator.previous();
            iterator.remove();
        }
    }

    private static void orderD() {
        if(iterator.hasNext())
            iterator.next();
    }

    private static void orderL() { 
        if(iterator.hasPrevious())
            iterator.previous();
    }
}
