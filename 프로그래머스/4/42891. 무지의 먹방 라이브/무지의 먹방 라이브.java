import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        // 1회전에 걸리는 시간 food_times
        PriorityQueue<Food> foodQueue = new PriorityQueue<>((a,b)->{
            if(a.remain==b.remain){
                return a.number-b.number;
            }
            
            return a.remain-b.remain;
        });
        int n = food_times.length;
        List<Food> foodList = new ArrayList<>();
        for(int i=0;i<n;i++){
            Food curFood = new Food(i+1,food_times[i]);
            foodQueue.offer(curFood);
            foodList.add(curFood);
        }
        
        int beforeUse = 0;
        while(k>=0){
            if(foodQueue.isEmpty()){
                break;
            }
            Food curFood = foodQueue.poll();
            int curRemain = curFood.remain-beforeUse;
            long untilCurFood = (long)n*curRemain;
            if(k<untilCurFood){
                break;
            }
            
            k-=untilCurFood;
            beforeUse +=curRemain;
            n--;
        }
        if(n!=0){
           k%=n;
        }

        int cnt = 0;
        int answer = -1;
        for(int i=0;i<foodList.size();i++){
            Food curFood = foodList.get(i);
            if(curFood.remain-beforeUse>0) {
                cnt++;
                if(cnt-1==k)
                answer = curFood.number;
            }
   
        }

        return answer;
    }
}

class Food{
    int number;
    int remain;
    
    public Food(int number, int remain){
        this.number = number;
        this.remain = remain;
    }
}