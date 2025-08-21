import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // skill charArray로 변환
        char[] skillArray = skill.toCharArray();
        // charArray 순회하며 map에 <skill, index> 저장
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<skillArray.length;i++){
            map.put(skillArray[i],i);
        }
        // skill_trees 순회
        for(int i=0;i<skill_trees.length;i++){
             // isAvailable = true 선언
            boolean isAvailable = true;
             // 각 스킬트리 charArray로 변환하여 순회
            char[] currentSkills = skill_trees[i].toCharArray();
                    // 현재 필요한 스킬순서 인덱스 선언 : default(0);
        int requiredOrder = 0;
            for(int j=0;j<currentSkills.length;j++){
                  // 현재 스킬이 map에 없다면 coninue;
                char currentSkill = currentSkills[j];
                if(!map.containsKey(currentSkill)) continue;
                 // map에 있다면 현재 인덱스와 같은지 확인
                int skillOrder = map.get(currentSkill);
                if(skillOrder != requiredOrder){
                    isAvailable = false;
                    break;
                }
                requiredOrder++;
            }
            if(isAvailable)
                answer++;
            
        }
        // 다르다면 isAvailable = false 후 break;
       return answer;
    }
}