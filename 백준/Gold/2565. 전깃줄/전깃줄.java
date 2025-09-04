import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map  =new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Pair[] pairs = new Pair[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(a,b);
        }

        Arrays.sort(pairs,(a,b)->a.a-b.a);
        int[] dp = new int[n];
        int len = 0;
        
        for(int i=0;i<n;i++){
            int pos = Arrays.binarySearch(dp,0,len,pairs[i].b);
            if(pos<0){
                pos = -(pos)-1;
            }
            
            dp[pos] = pairs[i].b;
            if(pos==len)
                len++;
        }
        System.out.println(n-len);
        

    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
