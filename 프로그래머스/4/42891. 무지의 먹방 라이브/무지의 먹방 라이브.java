import java.util.*;

class Solution {
		class Food implements Comparable<Food>{
			int order;
			int remain;
			int curIndex;

			public Food(int order, int remain){
				this.order = order;
				this.remain = remain;
				this.curIndex = order;
			}

			public int compareTo(Food o){
				if(this.remain==o.remain)
					return this.order-o.order;

				return this.remain-o.remain;
			}
		}

		public int solution(int[] food_times, long k) {
			// 1회전에 드는 시간 T : 현재 남아있는 음식의 양
			// T*(제일 적게 남아있는 양) + 제일 적게 남아있는 음식의 현재 순서
			int T = food_times.length;
			LinkedList<Food> rail = new LinkedList<>();
			Food[] foods = new Food[T];

			for(int i=0;i<T;i++){
				Food food = new Food(i,food_times[i]);
				rail.add(food);
				foods[i] = food;
			}

			Arrays.sort(foods);

			int curRemainIndex = 0;
			int used = 0;
			

			while(curRemainIndex<foods.length&&k>=T*(foods[curRemainIndex].remain-used)){
				if(foods[curRemainIndex].remain-used>0){
					k-=T*(foods[curRemainIndex].remain-used);
					used += foods[curRemainIndex].remain-used;
				}

				rail.remove(foods[curRemainIndex].curIndex);
				for(int i=foods[curRemainIndex].curIndex;i<rail.size();i++){
					rail.get(i).curIndex=i;
				}
				T = rail.size();
				curRemainIndex++;
			}

			if(rail.size()==0) return -1; 
			return rail.get((int)(k % rail.size())).order+1;

		}
	}