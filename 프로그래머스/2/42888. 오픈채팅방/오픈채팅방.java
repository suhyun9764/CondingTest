import java.util.*;


class Solution {
        public String[] solution(String[] record) {
            // 채팅방에 있는 유저 목록
            Map<String, String> users = new HashMap();
            // 출입 로그
            String[][] log = new String[record.length][2];
            int logSize = 0;    // 로그에 추가될 때 마다 +1
            // record 순회
            for (String userAction : record) {
                String[] section = userAction.split(" ");
                // 정보 추출
                String action = section[0];
                // 들어왔을 때
                if (action.equals("Enter")) {
                    String uid = section[1];
                    String nickName = section[2];
                    log[logSize][0] = uid;
                    log[logSize][1] = action;
                    logSize++;
                    users.put(uid,nickName);
                } else if (action.equals("Leave")) {   // 나갈 때
                    String uid = section[1];
                    log[logSize][0] = uid;
                    log[logSize][1] = action;
                    logSize++;
                } else {// 닉네임 변경할 때
                    String uid = section[1];
                    String nickName = section[2];
                    users.put(uid,nickName);
                }
            }

            String[] answer = new String[logSize];
            for(int i=0;i<answer.length;i++){
                String[] currentLog = log[i];
                String uid = currentLog[0];
                String action = currentLog[1];
                String nickName= users.get(uid);

                if(action.equals("Enter")){
                    answer[i] = nickName+"님이 들어왔습니다.";
                }else{
                    answer[i] = nickName+"님이 나갔습니다.";
                }
            }

            return answer;
        }
    }