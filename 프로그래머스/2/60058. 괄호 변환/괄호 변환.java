import java.util.*;

class Solution {
        StringBuilder sb = new StringBuilder();
        public String solution(String p) {
            // index가 p길이보다 작을때까지만 순회
            // (와 )의 값이 같아 질때까지 index ++
            // 해당값까지가 u, 나머지는 v
            // 만약 u가 올바른 괄호문자열이라면 그대로 두고 v1번부터 다시
            // 만약 u가 올바른 문자열 아니라면 아래 규칙따르기
            /*
            4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            4-3. ')'를 다시 붙입니다.
            4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
             4-5. 생성된 문자열을 반환합니다.
             */

            return dfs(p);
        }

        private String dfs(String p) {
            if(p.length()==0)
                return "";

            String[] uAndV = findUandV(p);
            String u = uAndV[0];
            String v = uAndV[1];



            if(isPerfect(u)){
                return u+dfs(v);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(dfs(v));
            sb.append(")");
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='(') sb.append(')');
                if(u.charAt(i)==')') sb.append('(');
            }
            return sb.toString();
        }

        private boolean isPerfect(String u) {
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<u.length();i++){
                char cur = u.charAt(i);
                if(cur=='(') stack.push('(');
                if(cur==')'){
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
            if(stack.isEmpty()) return true;
            return false;
        }

        private String[] findUandV(String p) {
            int openCnt = 0;
            int closeCnt = 0;
            String[] result = new String[2];
            for(int i=0;i<p.length();i++){
                if(p.charAt(i)=='(') openCnt++;
                if(p.charAt(i)==')') closeCnt++;

                if(closeCnt!=openCnt) continue;

                result[0] = p.substring(0,i+1);
                result[1] = p.substring(i+1);
                break;
            }

            return result;
        }
    }