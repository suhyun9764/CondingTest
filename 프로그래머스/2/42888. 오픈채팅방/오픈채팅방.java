import java.util.*;

class Solution {

        class Log{
            String uid;
            String order;

            public Log(String uid, String order) {
                this.uid = uid;
                this.order = order;
            }

            public String toPrint(String nickName){
                if(order.equals("Enter"))
                    return nickName+"님이 들어왔습니다.";

                return nickName+"님이 나갔습니다.";
            }
        }


        public String[] solution(String[] record) {
            // map에 uuid, 닉네임 저장
            // log클래스 만들기 (uuid, 동작)
            // record 파싱 방법
            /*
            1. 공백으로 분리
            2. Enter, Change라면 필드 3개, 아니면 2개
            3. 첫번째는 무조건 동작, 두번째는 아이디, 세번째는 닉네임
             */
            Map<String,String> map = new HashMap<>();
            List<Log> list = new ArrayList<>();
            for(int i=0;i<record.length;i++){
                String[] fields = record[i].split(" ");
                String order = fields[0];
                String uid = fields[1];
                String nickname = null;
                if(fields.length==3)
                    nickname = fields[2];

                if(order.equals("Change")){
                    map.put(uid,nickname);
                    continue;
                }

                list.add(new Log(uid,order));
                if(order.equals("Enter"))
                    map.put(uid,nickname);

            }
            String[] answer = new String[list.size()];
            for(int i=0;i<answer.length;i++){
                Log log = list.get(i);
                answer[i] = log.toPrint(map.get(log.uid));
            }

            return answer;

        }
    }