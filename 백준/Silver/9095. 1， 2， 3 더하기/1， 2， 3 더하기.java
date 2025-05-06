
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int[] resultList = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        fillResultList();
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(resultList[n]);
        }
    }

    private static void fillResultList() {
        resultList[1] = 1;
        resultList[2] = 2;
        resultList[3] = 4;
        for(int i=4;i<=11;i++){
            resultList[i] = resultList[i-1]+resultList[i-2]+resultList[i-3];
        }
    }
}
