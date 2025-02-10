import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 문자열 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("."))
                break;
            char[] charArray = input.toCharArray();
            List<Character> list = new ArrayList<>();

            // 2. 문자열에서 소괄호와 대괄호 추출하기
            for (char c : charArray) {
                if (c == '(' || c == ')' || c == '[' || c == ']')
                    list.add(c);
            }
            String answer = getAnswer(list);
            System.out.println(answer);
        }

    }

    private static String getAnswer(List<Character> list) {
        /* 3. 열린 괄호(소, 대)일 경우 stack에 넣고
           닫힌 괄호일 경우 stack에서 pop하여 자신과 짝이 맞는지 확인
         */
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            Character currentChar = list.get(i);
            if (currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            }else {
                if (currentChar == ')') {
                    if(stack.isEmpty())
                        return "no";
                    Character pop = stack.pop();
                    if (pop != '(') {
                        return "no";
                    }
                } else {
                    if(stack.isEmpty())
                        return "no";
                    Character pop = stack.pop();
                    if (pop != '[') {
                        return "no";
                    }
                }
            }
        }
        // 4. 모든 연산이 끝나고 stack에 남아있는지 확인 후 남아있다면 no, 없으면 yes
        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }

}
