import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken()); // 총 카드의 개수
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){ // 카드에 적힌 수
            arr[i] = Integer.parseInt(st.nextToken());  // 시간 복잡도 O(N)
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 비교해야 할 카드 개수
        int[] ansArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int target = Integer.parseInt(st.nextToken());
            int lower = getLower(arr,target);
            int upper = getUpper(arr,target);

            ansArr[i] = upper - lower;
        }


        for(int i=0;i<ansArr.length;i++){
            bw.write(ansArr[i]+" ");
        }

        bw.flush();
    }

    private static int getUpper(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int index=arr.length;
        while(start<=end){
            int m = (start+end)/2;
            if(arr[m]<=target) start = m+1;
            else{
                end = m-1;
                index = m;
                //return getSameNum(arr,m);
            }
        }
        return index;
    }

    private static int getLower(int[] arr, int target) { // 시간 복잡도 O(logn)
        int start = 0;
        int end = arr.length-1;
        int index=arr.length;
        while(start<=end){
            int m = (start+end)/2;
            if(arr[m]<target) start = m+1;
            else{
                end = m-1;
                index = m;
                //return getSameNum(arr,m);
            }
        }
        return index;
    }


}
