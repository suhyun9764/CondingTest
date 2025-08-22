import java.util.*;

class Solution {
    boolean solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('P',0);
        map.put('Y',0);
        
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            c = Character.toUpperCase(c);
            if(c=='P'||c=='Y')
            map.put(c,map.get(c)+1);
        }
        
        if(map.get('P')==map.get('Y'))
            return true;
        
        return false;
    }
}