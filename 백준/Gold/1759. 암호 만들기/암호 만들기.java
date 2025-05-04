import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L,C;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        init();
        for(int i=0;i<C;i++){
            boolean[] visit = new boolean[C];
            visit[i] = true;
            StringBuilder sb = new StringBuilder();
            String result = String.valueOf(arr[i]);
            dfs(i,visit,1,result);
        }
    }

    private static void dfs(int current, boolean[] visit, int depth, String result) {
        if(depth==L&&validResult(result)){
            System.out.println(result.toString());
            return;
        }

        for(int i=current+1;i<C;i++){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(i,visit,depth+1,result+String.valueOf(arr[i]));
            visit[i] = false;
        }
    }

    private static boolean validResult(String result) {
        char[] gather = {'a','e','i','o','u'};
        int gatherCount = 0;
        for(int i=0;i<result.length();i++){
            char currentChar = result.charAt(i);
            for(int j=0;j<gather.length;j++){
                if(currentChar==gather[j]){
                    gatherCount++;
                    break;
                }
            }
        }

        int nonGatherCount = result.length()-gatherCount;
        if(gatherCount>=1&&nonGatherCount>=2)
            return true;

        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
    }
}
