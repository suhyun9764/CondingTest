import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 해당 인덱스 = 전체 원소 수 - map에 저장된 수
        List<List<Integer>> info = getInfo(s);    
        Map<Integer, Integer> map = new HashMap<>();
        
        
        int[] answer = new int[info.size()];
        
        for(List<Integer> l : info){
            for(int i : l){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getKey();
            int num = entry.getValue();
            
            int index = info.size()-num;
            answer[index] = value;
        }
        return answer;
    }
    
    private List<List<Integer>> getInfo(String s){
        /*
        {1,2,3},{2,1},{1,2,4,3},{2}
        */
        
        List<List<Integer>> list = new ArrayList<>();
        s = s.substring(1,s.length()-1);// 밖에 있는 괄호 제거
        List<Integer> atoms = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='{') continue;
            if(c==',') {
                if(sb.length()==0) continue;
                atoms.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            if(c=='}'){
                atoms.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
                list.add(atoms);
                atoms = new ArrayList<>();
            }
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }

        return list;
    }
}