
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static String[] arr;
    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N+1];
        for(int i=1;i<N+1;i++){
            String name = br.readLine();
            arr[i] = name;
            map.put(name,i);
        }

        for(int i=0;i<M;i++){
            String input = br.readLine();
            if(map.containsKey(input)) {
                System.out.println(map.get(input));
            }else{
                System.out.println(arr[Integer.parseInt(input)]);
            }
        }
    }
}
