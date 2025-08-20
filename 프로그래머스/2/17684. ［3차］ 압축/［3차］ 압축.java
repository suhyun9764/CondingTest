import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        char[] charArray = msg.toCharArray();
        
        int indexNum = 27;
        // charArray로 변환 후 순회
        List<Integer> answer = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<charArray.length;){
            int currentI = i;
            if(i==charArray.length-1){
                answer.add(charArray[i++]-'A'+1);
                continue;
            }
            Integer indexValue = null;
            sb.append(charArray[i++]);
            sb.append(charArray[i]);
    
            while(map.containsKey(sb.toString())){
                indexValue = map.get(sb.toString());
                if(i+1==charArray.length){
                    i++;
                    break;
                }
                sb.append(charArray[++i]);
            }
            
            if(indexValue==null){
                answer.add(charArray[currentI]-'A'+1);
            }else{
                answer.add(indexValue);
            }
            
            map.put(sb.toString(),indexNum++);
            sb.setLength(0);
        }

        int[] answerArray = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;

  
                   // sb.toString()이 사전에 있을때까지 반복
        // 색인이있다면 색인출력 없다면 첫글자 출력
        // 다음글자가 있다면 현재 글자 + 다음글자를 map에 현재 인덱스에 저장
        
    }
}