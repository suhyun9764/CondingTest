import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        char[] arr = st.nextToken().toCharArray();
        int start =0;
        int end =0;
        int cnt =1;
        int max = 0;
        int[] checkArr = new int[26];

        for(int i=0;i<arr.length;i++){
            while (end<arr.length){
                checkArr[arr[end++]-'a']++;
                if(getTotalAlpahbetNum(checkArr)>n){
                    checkArr[arr[--end]-'a']--;
                    break;
                }
            }

            int currentLength = end-i;
            max = Math.max(currentLength,max);
            checkArr[arr[i]-'a']--;
        }

        System.out.println(max);

    }

    private static int getTotalAlpahbetNum(int[] checkArr) {

        int cnt =0;
        for(int i=0;i<checkArr.length;i++){
            if(checkArr[i]>0)
                cnt++;
        }

        return cnt;
    }

}
