
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 30의 배수가 되기 위해서는 0이 하나이상 있어야 하고 모든 자릿수의 합이 3의 배수가 되면 된다
        // 만약 3의 배수가 된다면 내림차순으로 정렬 하면 가장 큰 수가 된다
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        String[] split = n.split("");

        Arrays.sort(split,Comparator.reverseOrder());
        if(!split[split.length-1].equals("0")){
            System.out.println(-1);
            return;
        }

        int sum = 0;

        for (int i = 0; i < split.length; i++) {
            sum+= Integer.parseInt(split[i]);

        }
        if(sum<3||sum%3!=0){
            System.out.println(-1);
            return;
        }

        String answer = "";
        for (String number : split) {
            answer += String.valueOf(number);
        }

        System.out.println(answer);


    }
}
