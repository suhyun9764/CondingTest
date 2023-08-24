import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 질문 갯수
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int x = Integer.parseInt(st.nextToken()); // 찾아야되는 수
            Boolean result = findValue(arr,x);
            int ans = result ? 1:0;
            bw.write(ans+"\n");
        }
        bw.flush();
    }

    private static Boolean findValue(int[] arr, int x) {
        int end = arr.length-1;
        int start = 0;
        while(start<=end){
            int m = (start+end)/2;
            if(arr[m]>x)  end=m-1;
            else if(arr[m]<x) start=m+1;
            else return true;
        }
        return false;
    }
}
