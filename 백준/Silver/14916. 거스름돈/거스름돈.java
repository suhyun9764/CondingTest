import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //거스름돈이 최소가 되려면 값이 큰 동전을 최대한 쓰고 나머지를 작은 동전으로 처리한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int big = 5;   
        int small = 2;

        int bigNum = n/big;
        int remain = n-(bigNum*big);
        if(remain%2==1) {
            bigNum-=1;
            remain+=big;
        }

        if(bigNum<0){
            System.out.println(-1);
            return;
        }

        int smallNum = remain/small;
        System.out.println(smallNum+bigNum);


    }
}
