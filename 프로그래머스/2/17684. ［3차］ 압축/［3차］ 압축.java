import java.util.*;

class Solution {
        public int[] solution(String msg) {
            // msg 순회
            // 현재 인덱스가 사전에 등록되어있을때까지 sb에 append
            // sb를 통해 인덱스값 출력, 그리고 그 다음글자는 마지막인덱스에 저장
            Map<String, Integer> map = new HashMap<>();
            for(int i=1;i<27;i++){
                map.put(String.valueOf((char)('A'+i-1)),i);
                // System.out.println(String.valueOf((char)('A'+i-1)));
            }
            char[] arr = msg.toCharArray();
            int index = 27;
            List<Integer> answerList = new ArrayList<>();

            int i=0;
            while(i<msg.length()){
                StringBuilder sb = new StringBuilder();
                while(map.containsKey(sb.toString()+arr[i])){
                    System.out.println(i);
                    System.out.println(sb.toString()+arr[i]);
                    sb.append(arr[i]);

                    i++;
                    if(i==msg.length())
                        break;
                }
                answerList.add(map.get(sb.toString()));
                if(i==msg.length())
                    break;;
                map.put(sb.append(arr[i]).toString(),index++);

            }

            int[] answer = new int[answerList.size()];
            for(int t=0;t<answerList.size();t++){
                answer[t] = answerList.get(t);
                // System.out.println(answerList.get(i));
            }

            return answer;
        }
    }