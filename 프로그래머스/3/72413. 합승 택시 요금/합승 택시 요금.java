import java.util.*;

class Solution {
		int N;
		public int solution(int n, int s, int a, int b, int[][] fares) {
			N = n;
			int[][] map = new int[n+1][n+1];
			for(int i=0;i<n+1;i++){
				Arrays.fill(map[i],-1);
			}

			for(int i=0;i<fares.length;i++){
				int start = fares[i][0];
				int end= fares[i][1];

				map[start][end] = fares[i][2];
				map[end][start] = fares[i][2];
			}


			// 환승지점 h : (a+h)+(h+a)+(h+b) 최소값 구하기
			int[] sMap = getMinPrice(s,map);
			// 2. 출발지에서 B로 가는 최단 경로
			int[] aMap = getMinPrice(a,map);
			// 3. A에서 B로 가는 최단 경로
			int[] bMap= getMinPrice(b,map);

			int answer = Integer.MAX_VALUE;
			for(int i=1;i<N+1;i++){
				int sum = sMap[i] + aMap[i] + bMap[i];
				answer=Math.min(answer, sum);
			}
			// 1+2 or 1+3 or 2+3
			return answer;
		}

		private int[] getMinPrice(int a, int[][] map) {
			int[] curMap = new int[N+1];
			Arrays.fill(curMap,Integer.MAX_VALUE);
			curMap[a] = 0;
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(a);

			while (!queue.isEmpty()){
				int cur = queue.poll();

				for(int i=1;i<N+1;i++){
					if(i==cur) continue;
					if(map[cur][i]!=-1&&curMap[i]>curMap[cur]+map[cur][i]){
						queue.add(i);
						curMap[i] = curMap[cur]+map[cur][i];
					}
				}
			}

			return curMap;


		}
	}