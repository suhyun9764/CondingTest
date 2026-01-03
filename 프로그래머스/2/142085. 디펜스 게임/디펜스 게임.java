import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 7보다 크거나 같아 질때까지 순회
        // 만약 해당 인덱스에서 n보다 크거나 같아진다면 지금까지의 스테이지에서 가장 큰곳에 무적권
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<enemy.length;i++){
            int curEnemy = enemy[i];
            // System.out.print(i+":");
            if(curEnemy>n){
                // System.out.print("use coupon");
                if(k==0)
                    return i;
                
                if(pq.isEmpty()){
                    k--;
                    continue;
                }
                
                boolean isMax = false;
                while(!pq.isEmpty()&&curEnemy>n&&k>0){
                    int curMax= pq.peek();
                    if(curMax<curEnemy){
                        isMax = true;
                        break;
                    }
                    pq.poll();
                    k--;
                    n+=curMax;
                }
                
                if(isMax){
                    k--;
                    continue;
                }
                
                if(curEnemy>n&&pq.isEmpty()&&k>0){
                    k--;
                    continue;
                }
                
                if(n<curEnemy)
                    return i;
            }
            pq.add(curEnemy);
            n-=curEnemy;
            // System.out.println();
        }
        
        return enemy.length;
    }
}