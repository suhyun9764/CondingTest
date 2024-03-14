import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputBoard = br.readLine();

        String answer = "";
        String A = "AAAA";
        String B = "BB";

        inputBoard = inputBoard.replaceAll("XXXX", A);
        answer = inputBoard.replaceAll("XX",B);
        if(answer.contains("X")){
            answer = "-1";
        }
        System.out.println(answer);

    }
}
