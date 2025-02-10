import java.util.Stack;

class Solution {
    boolean solution(String s) {
            char[] charArray = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < charArray.length; i++) {
                char current = charArray[i];
                if (current == '(') {
                    stack.push(current);
                } else {
                    if (stack.isEmpty())
                        return false;
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                return true;

            return false;
    }
}