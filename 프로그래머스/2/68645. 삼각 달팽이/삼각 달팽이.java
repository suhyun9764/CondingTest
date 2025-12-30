import java.util.*;

class Solution {
    int[] dy = {1,0,-1};
    int[] dx = {0,1,-1};
    public int[] solution(int n) {
        int d = 0;
        int y = 0;
        int x = 0;
        List<int[]> floors = new ArrayList<>();
        for(int i=0;i<n;i++){
            floors.add(new int[i+1]);
        }
        
        int total = (n*(n+1))/2;
        
        for(int i=1;i<=total;i++){
            int[] arr = floors.get(y);
            arr[x] = i;
            
          
            if(d==0){
                if(y==n-1){
                    d++;
                }else{
                    if(floors.get(y+1)[x]!=0){
                        d++;
                    }
                }
                y = y+dy[d];
                x = x+dx[d];
                continue;
            }
             if(d==1){
                 if(x==n-1){
                    d++;
                }else{
                    if(floors.get(y)[x+1]!=0){
                        d++;
                    }
                }
                y = y+dy[d];
                x = x+dx[d];
                continue;
            }
            
            if(floors.get(y-1)[x-1]!=0) d=0;
            
            y = y+dy[d];
            x = x+dx[d];
            
        }
        
        int[] answer = new int[total];
        int index = 0;
        for(int i=0;i<n;i++){
            int[] arr = floors.get(i);
            for(int j=0;j<arr.length;j++){
                answer[index++] = arr[j];
            }
        }
        
        return answer;
    }
}