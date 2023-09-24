import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray(); // 방번호
        int checkUse[] = new int[10]; // 숫자 사용 횟수
        int sixOrNine = 0; // 6과 9의 사용 횟수
        for(int i=0;i<arr.length;i++){
            int num = arr[i]-'0';
            if(num==6||num==9) sixOrNine++;
            checkUse[num]++;
        }
        if(sixOrNine%2==1)sixOrNine = sixOrNine/2+1; //6과 9의 사용횟수가 홀수면 반으로 나누고 +1
        else sixOrNine = sixOrNine/2; 
        checkUse[6] = sixOrNine;
        checkUse[9] = sixOrNine;
        int max = 0;
        for(int i=0;i<checkUse.length;i++){
            if(checkUse[i]>max) max = checkUse[i];
        }

        System.out.println(max);


    }
}
