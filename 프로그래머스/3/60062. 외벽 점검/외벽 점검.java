import java.util.*;

class Solution {
		public int solution(int n, int[] weak, int[] dist) {
			int weakNum = weak.length;
			int[] newWeak = new int[2*weakNum];
			for(int i=0;i<weak.length;i++){
				newWeak[i] = weak[i];
				newWeak[i+weakNum] = weak[i]+n;
			}

			int[][] orderList = getAllOrder(dist); // 순서 조합

			int answer = dist.length+1;

			for(int[] order : orderList){ // 현재 순서 ex : 1,2,3,4
				int cnt = 0;

				for(int i=0;i<weakNum;i++){ // weak 순서대로
					int person = 1;
					int p = 0;
					int pos = weak[i] + order[p];
					for(int s = i;s<i+weakNum;s++){
						if(newWeak[s] > pos){
							person++;
							p++;
							if(p==dist.length) break;
							pos = newWeak[s]+order[p];

						}

					}
					answer = Math.min(answer,person);
				}
			}

			if(answer==dist.length+1) return -1;
			return answer;
		}

		private int[][] getAllOrder(int[] dist){
			List<int[]> list = new ArrayList<>();
			dfs(0,list,new int[dist.length],dist,new boolean[dist.length]);
			int[][] result = new int[list.size()][dist.length];
			for(int i=0;i<list.size();i++){
				result[i] = list.get(i);
			}
			return result;
		}

		private void dfs(int depth, List<int[]> list, int[] arr, int[] dist, boolean[] selected){
			if(depth==arr.length){
				list.add(Arrays.copyOf(arr,arr.length));
				return;
			}

			for(int i=0;i<dist.length;i++){
				if(selected[i]) continue;
				selected[i] = true;
				arr[depth] = dist[i];
				dfs(depth+1,list,arr,dist,selected);
				arr[depth] = 0;
				selected[i] = false;
			}
		}
	}