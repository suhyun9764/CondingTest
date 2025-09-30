import java.util.*;

class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Set<String>> declared = new HashMap<>();
            Map<String, Set<String>> declare = new HashMap<>();
            for(int i=0;i<id_list.length;i++){
                declared.put(id_list[i],new HashSet<>());
                declare.put(id_list[i],new HashSet<>());
            }

            for(int i=0;i<report.length;i++){
                String curReport = report[i];
                String declarePerson = curReport.split(" ")[0];
                String declaredPerson = curReport.split(" ")[1];

                declare.get(declarePerson).add(declaredPerson);
                declared.get(declaredPerson).add(declarePerson);
            }

            int[] answer = new int[id_list.length];
            for(int i=0;i<id_list.length;i++){
                String user = id_list[i];
                Set<String> declaredUsers = declare.get(user);
                for(int d=0;d<id_list.length;d++){
                    String curUser = id_list[d];
                    if(!declaredUsers.contains(curUser)) continue;
                    if(declared.get(curUser).size()>=k)
                        answer[i]++;
                }
            }

            return answer;
        }
    }