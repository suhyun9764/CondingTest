import java.util.*;

class Solution {
        public int solution(String s) {
            int answer = 0;
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            // 1. char[]배열로 저장하기
            char[] charArray = s.toCharArray();
            // 2. Queue에 저장하기
            Queue<Character> queue = new ArrayDeque<>();
            for (char c : charArray) {
                queue.offer(c);
            }
            // 3. s.length()-1만큼 순회하며 왼쪽으로 회전(poll 후 offer)
            for (int i = 0; i < s.length() - 1; i++) {
                if (i != 0) {   // 0이면 회전 x
                    queue.offer(queue.poll());
                }
                // 4. 각 회전마다 스택을 만들어 문자열 하나씩 스택에 담아 쌍이 맞춰질때마다 제거하여
                // 문자열 전체를 돌았을 때 스택이 비어있다면 answer++;
                Deque<Character> stack = new ArrayDeque<>();

                int circularCnt = 0;
                boolean isValid = true;
                for (int j = 0; j < s.length(); j++) {
                    char currentC = queue.poll();
                    circularCnt++;
                    if (!map.containsKey(currentC)) {
                        stack.push(currentC);
                    } else {
                        if (!stack.isEmpty()&&stack.peek().equals(map.get(currentC)))
                            stack.pop();
                        else{
                            isValid = false;
                            queue.offer(currentC);
                            for(int k=0;k<s.length()-circularCnt;k++){

                                queue.offer(queue.poll());
                            }
                            break;
                        }
                    }
                    queue.offer(currentC);
                }
                if (stack.isEmpty()&&isValid)
                    answer++;
            }
            return answer;
        }
    }