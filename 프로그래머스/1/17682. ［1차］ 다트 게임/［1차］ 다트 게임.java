import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // dartResult char[]로 
        // charArr 순회
        // index =0 시작
        // index ==2 가되었을때 해당값이 #,*이 아니면 0으로 초기화
        // 각 점수 list에 저장
        // 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.  
        // 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
        // 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
        // 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
        // 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
        char[] charArr = dartResult.toCharArray();

        LinkedList<Integer> scores = new LinkedList<>();
        
        int index = 0;
        int currentScore = 0;
        for(int i=0;i<charArr.length;i++){
            if(index==2){
                if(charArr[i]=='*'){
                    if(scores.size()>=1){
                        int score = scores.get(scores.size()-1);
                        System.out.println("before :" +score);
                        scores.removeLast();
                        scores.add(score*2);
                    }
                    scores.add(currentScore*2);
                    currentScore=0;
                    index =0;
                    continue;
                }
                else if(charArr[i]=='#'){
                    scores.add(currentScore*-1);
                    currentScore=0;
                    index = 0;
                    continue;
                }else{
                    scores.add(currentScore);
                    currentScore=0;
                    index = 0;
                }
            }
            
            if(index==0){
                currentScore=charArr[i]-'0';
            }
            
            if(index==1){
                int val = 1;
                if(charArr[i]=='0'){
                    currentScore=10;
                    continue;
                }
                if(charArr[i]=='D'){
                    val = 2;
                }
                
                if(charArr[i]=='T'){
                    val = 3;
                }
                currentScore = (int)Math.pow(currentScore,val);
       
            }
                     System.out.println(currentScore);
            index++;
        }
        
        scores.add(currentScore);
        int answer = 0;
        for(int i=0;i<scores.size();i++){
            System.out.print(scores.get(i)+" ");
            answer += scores.get(i);
        }
        return answer;
    }
}