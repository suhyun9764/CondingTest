import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            char[] arr = st.nextToken().toCharArray();
            int start = 0;
            int end = arr.length-1;
            int ans = 0;
            while (start<end){
                if(arr[start]!=arr[end]){
                    if(isPalindrom(arr,start+1,end)||isPalindrom(arr,start,end-1)) ans =1;
                    else ans = 2;
                    break;
                }
                start++;
                end--;
            }
            bw.write(ans+"\n");
        }

        bw.flush();
    }

    private static boolean isPalindrom(char[] arr, int start, int end) {
        while (start<end){
            if(arr[start]!=arr[end])
                return false;

            start++;
            end--;
        }
        return true;
    }


}
