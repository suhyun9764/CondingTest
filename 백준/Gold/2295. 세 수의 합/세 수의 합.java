import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Set<Integer> sumSet = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sumSet.add(arr[i]+arr[j]);
            }
        }

        int ans = 0;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<n;j++){
                int target = arr[i]-arr[j];
                if(sumSet.contains(target))
                    ans = Math.max(ans,arr[i]);
            }
        }
        

        System.out.println(ans);
    }

}
