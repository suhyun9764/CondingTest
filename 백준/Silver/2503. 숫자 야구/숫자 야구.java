 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] orderArr = new int[n][3];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                orderArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans =0;
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                for(int k=1;k<10;k++){
                    if(i==j||j==k||k==i) continue;
                    int correctCnt =0;
                    for(int q=0;q<n;q++){
                        int qx = orderArr[q][0]/100;
                        int qy = (orderArr[q][0]/10)%10;
                        int qz = orderArr[q][0]%10;

                        int strike =0, ball =0;
                        if(qx==i) strike++;
                        else if(qx==j||qx==k) ball++;
                        if(qy==j) strike++;
                        else if(qy==i||qy==k) ball++;
                        if(qz==k) strike++;
                        else if(qz==i||qz==j) ball++;

                        if(strike==orderArr[q][1]&&ball==orderArr[q][2]) correctCnt++;
                        else break;
                    }
                    if(correctCnt==n) ans++;

                }
            }
        }

        System.out.println(ans);
    }
}
