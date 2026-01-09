import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    String[] minerals;
    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        dfs(picks,0,0,0,0);
        return answer;
    }
    
    private void dfs(int[] picks, int use, int remain, int m, int sum){
        if(m==minerals.length){
            // System.out.println(sum);
            answer = Math.min(answer,sum);
            return;
        }
        
        String mineral = minerals[m];
        if(remain==0){
            boolean isNotExist = true;
            for(int i=0;i<3;i++){
                if(picks[i]==0) continue;
                isNotExist = false;
                picks[i] = picks[i]-1;
                int cost = getCost(i,mineral);
                dfs(picks,i,4,m+1,sum+cost);
                picks[i] = picks[i]+1;
            }
            if(isNotExist){
                // System.out.println(sum);
                answer = Math.min(sum,answer);
                return;
            }
        }else{
            int cost = getCost(use,mineral);
            dfs(picks,use,remain-1,m+1,sum+cost);
        }
       
    }
    
    private int getCost(int i, String mineral){
        if(i==0){
            if(mineral.equals("diamond")) return 1;
            if(mineral.equals("iron")) return 1;
            if(mineral.equals("stone")) return 1;
        }
        
        if(i==1){
            if(mineral.equals("diamond")) return 5;
            if(mineral.equals("iron")) return 1;
            if(mineral.equals("stone")) return 1;
        }
        
        if(i==2){
            if(mineral.equals("diamond")) return 25;
            if(mineral.equals("iron")) return 5;
            if(mineral.equals("stone")) return 1; 
        }
        
        return 0;
    }
}