import java.util.*;

class Solution {
    int answer = 0;
    int[] info;
    Map<Integer, Set<Integer>> nodes;
    public int solution(int[] info, int[][] edges) {
        // Map에 노드 정보 저장
        this.info = info;
        nodes = new HashMap<>();
        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            
            nodes.putIfAbsent(parent,new HashSet<>());
            nodes.get(parent).add(child);
        }
        // root부터 dfs
        dfs(0,0,0,new ArrayList<>());
        return answer;
    }
    
    private void dfs(int node, int sheep, int wolf, List<Integer> ways){
        if(info[node]==0){
            sheep++;
        }
        
        if(info[node]==1){
            wolf++;
        }
        
        if(wolf>=sheep){
            return;
        }
        Set<Integer> children = nodes.get(node);
        if(children!=null){
            for(int child : children){
                ways.add(child);
            }
        }
        
        for(int way : ways){
            List<Integer> newWays = new ArrayList<>();
            for(int w : ways){
                newWays.add(w);
            }
            newWays.remove(Integer.valueOf(way));
            dfs(way,sheep,wolf,newWays);
        }
        
        answer = Math.max(answer,sheep);
        
    }
}
