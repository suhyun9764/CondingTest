import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] arr = new char[s];
        st = new StringTokenizer(br.readLine());
        arr = st.nextToken().toCharArray();

        int[] checkArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] currentArr = new int[4];
        for(int i=0;i<p;i++){
            switch (arr[i]){
                case 'A':
                    currentArr[0]++;
                    break;
                case 'C':
                    currentArr[1]++;
                    break;
                case 'G':
                    currentArr[2]++;
                    break;
                case 'T':
                    currentArr[3]++;
                    break;
            }
        }
        int cnt=0;
        if(comparePwd(currentArr,checkArr)){
            cnt++;
        }
        int start = 1;
        int end = p;

        while (end<arr.length){
            updateCurrentArr(currentArr,arr,start,end);
            if(comparePwd(currentArr,checkArr)){
                cnt++;
            }
            start++;
            end++;

        }

        System.out.println(cnt);


    }

    private static void updateCurrentArr(int[] currentArr, char[] arr, int start, int end) {
        switch (arr[start-1]){
            case 'A':
                currentArr[0]--;
                break;
            case 'C':
                currentArr[1]--;
                break;
            case 'G':
                currentArr[2]--;
                break;
            case 'T':
                currentArr[3]--;
                break;
        }

        switch (arr[end]){
            case 'A':
                currentArr[0]++;
                break;
            case 'C':
                currentArr[1]++;
                break;
            case 'G':
                currentArr[2]++;
                break;
            case 'T':
                currentArr[3]++;
                break;
        }

    }

    private static boolean comparePwd(int[] currentArr, int[] checkArr) {
        int checkCnt =0;
        for(int i=0;i<currentArr.length;i++){
            if (currentArr[i]>=checkArr[i])
                checkCnt++;
        }
        if(checkCnt==4)
            return true;
        else
            return false;
    }
}
