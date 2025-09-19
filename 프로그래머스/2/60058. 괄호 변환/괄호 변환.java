import java.util.*;
class Solution {
        public String solution(String p) {
            // 1. p를 charArr로
            // 2. charArr 순회
            // 3. '('랑 ')'가 같아질때까지 index올리기
            // 4. 추출된 문자열 올바른 괄호 문자열인지 확인
            // 5. 올바른 괄호 문자열이 맞다면 그대로 두고 v에 대해 1번부터 다시 수행
            // 6. 올바른 괄호 문자열이 아니라면 1단계부터 다시 수행한 v를 (뒤에 붙혀넣고 )붙히고 앞뒤를 짜른 u를 () 바꿔서 붙히기

            String answer = getValidString(p);
            return answer;
        }

        private String getValidString(String p) {
            char[] charArray = p.toCharArray();
            if(isValid(charArray)) return p;

            int open = 0;
            int close = 0;

            String u = "";
            String v = "";

            for(int i=0;i<charArray.length;i++){
                char cur = charArray[i];
                if(cur=='(') open++;
                if(cur==')') close++;

                if(close==open){
                    u = p.substring(0,i+1);
                    if(i+1<p.length())
                        v = p.substring(i+1);
                    break;
                }
            }


            v = getValidString(v);
            if(isValid(u.toCharArray())){
                return u+v;
            }

            u = reverse(u);
            return "("+v+")"+u;
        }

        private String reverse(String u) {
            if(u.length()<=2)
                return "";

            u = u.substring(1, u.length() - 1);
            char[] charArray = u.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<charArray.length;i++){
                char cur = charArray[i];
                if(cur=='(')
                    sb.append(')');

                else
                    sb.append('(');
            }

            return sb.toString();
        }

        private boolean isValid(char[] charArray) {
            Stack<Character> stack = new Stack();
            for(int i=0;i<charArray.length;i++){
                char cur = charArray[i];
                if(cur=='('){
                    stack.push(cur);
                    continue;
                }

                if(stack.isEmpty()) return false;

                if(stack.peek()=='('){
                    stack.pop();
                }
            }

            return true;
        }
    }