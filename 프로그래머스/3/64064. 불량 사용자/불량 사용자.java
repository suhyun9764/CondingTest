import java.util.*;

class Solution {
    String[] banned_id;
    Set<String> answer = new HashSet<>();
    int bannedNum;
    Map<Integer,List<String>> map;
    public int solution(String[] user_id, String[] banned_id) {
        this.banned_id = banned_id;
        bannedNum = banned_id.length;
        System.out.println(bannedNum);
        // user_id 길이별로 map에 저장
        map = new HashMap<>();
        for(String id : user_id){
            int length = id.length();
            map.putIfAbsent(length,new ArrayList<>());
            map.get(length).add(id);
        }
        
        dfs(0,new HashSet<>());
        return answer.size();
    }
    
    private void dfs(int depth, Set<String> set){
        if(depth==bannedNum){
            List<String> idList = new ArrayList<>(set);
            Collections.sort(idList);
            StringBuilder sb = new StringBuilder();
            for(String curId : idList){
                sb.append(curId);
            }
            
            answer.add(sb.toString());
            return;
        }
        boolean exist = false;
        
        String curBanned = banned_id[depth];
        int bannedLength = curBanned.length();
        
        List<String> list = map.get(bannedLength);
        for(String id : list){
            if(set.contains(id)) continue;
            if(!isMatch(id,curBanned)) continue;
            set.add(id);
            dfs(depth+1,set);
            set.remove(id);
        }
        
    }
    
    private boolean isMatch(String id, String banned){
        for(int i=0;i<id.length();i++){
            if(banned.charAt(i)=='*') continue;
            if(banned.charAt(i)!=id.charAt(i)) return false;
        }
        
        return true;
    }
}