import java.util.*;
class Solution {
        static Set<String> answer = new HashSet<>();
        public int solution(String[] user_id, String[] banned_id) {
            List[] candidates = new ArrayList[banned_id.length];
            for(int i=0;i<candidates.length;i++){
                candidates[i] = new ArrayList<Integer>();
            }
            // 1. 각 제제 아이디에 해당하는 아이디들 분류
            for(int i=0;i<banned_id.length;i++){
                String currentBannedId = banned_id[i];
                candidates[i] = findAvailableId(user_id,currentBannedId);
            }

            // 2. 오름차순 기준으로 선택
            boolean[] selected = new boolean[user_id.length];
            dfs(0,candidates,selected);
            return answer.size();
        }

        private void dfs(int index, List[] candidates, boolean[] selected) {
            if(index==candidates.length) {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<selected.length;i++){
                    if(selected[i])
                        sb.append(i);
                }
                answer.add(sb.toString());
                return;
            }


            List<Integer> currentCandidates = candidates[index];

            for (int i=0;i<currentCandidates.size();i++) {
                int currentCandidate = currentCandidates.get(i);
                if(selected[currentCandidate]) continue;
                selected[currentCandidate] = true;
                dfs(index+1,candidates,selected);
                selected[currentCandidate] = false;
            }
        }

        private List findAvailableId(String[] userIds, String currentBannedId) {
            List<Integer> userList = new ArrayList<>();
            for (int i = 0;i<userIds.length;i++) {
                String userId = userIds[i];
                if(userId.length()!=currentBannedId.length()) continue;
                boolean isMatch = true;
                for(int j=0;j<userId.length();j++){
                    if(currentBannedId.charAt(j)=='*') continue;
                    if(currentBannedId.charAt(j)!=userId.charAt(j)){
                        isMatch = false;
                        break;
                    }
                }
                if(isMatch)
                    userList.add(i);
            }

            return userList;
        }
    }