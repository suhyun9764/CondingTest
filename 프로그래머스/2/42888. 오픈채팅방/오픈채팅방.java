import java.util.*;

class Log{
        String action;
        String uid;

        public Log(String action, String uid) {
            this.action = action;
            this.uid = uid;
        }
    }
     class Solution {
        Map<String, String> userInfo = new HashMap<>();
        String[] result;
        List<Log> logList = new ArrayList<>();
        static final String ENTER = "들어왔습니다.";
        static final String LEAVE = "나갔습니다.";

        public String[] solution(String[] record) {
            for(int i=0;i<record.length;i++){
                precoessRecord(record[i]);
            }

            result = new String[logList.size()];
            convertLogToPrint();
            return result;
        }

        private void precoessRecord(String s) {
            String[] fields = s.split(" ");
            String action  = fields[0];
            String uid = fields[1];
            String newName = null;
            if(fields.length==3)
                newName = fields[2];
            if(action.equals("Change")){
                userInfo.put(uid,newName);
                return;
            }

            if(action.equals("Enter")){
                userInfo.put(uid,newName);
                logList.add(new Log(action,uid));
                return;
            }

            if(action.equals("Leave")){
                logList.add(new Log(action,uid));
            }
        }

        private void convertLogToPrint() {
            for(int i=0;i<logList.size();i++){
                Log log = logList.get(i);
                String action = log.action;
                String uid = log.uid;

                String nickname = userInfo.get(uid);
                if(action.equals("Enter")) result[i] = nickname+"님이 "+ENTER;
                if(action.equals("Leave")) result[i] = nickname+"님이 "+LEAVE;
            }
        }
    }