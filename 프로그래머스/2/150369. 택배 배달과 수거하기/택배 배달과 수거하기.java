import java.util.*;

class Solution {
		public long solution(int cap, int n, int[] deliveries, int[] pickups) {
			long answer = 0;

			int destination = deliveries.length-1;
			while (destination>=0){
				if(deliveries[destination]==0&&pickups[destination]==0) {
					destination--;
					continue;
				}
				int delComplete = destination+1;
				long remain = cap;

				for(int i=destination;i>=0;i--){
					long use = Math.min(remain,deliveries[i]);
					remain -= use;
					deliveries[i] -= use;
					if(deliveries[i]==0) delComplete = i;
					else break;
				}

				remain = cap;
				int pickUpComplete = destination+1;
				for(int i=destination;i>=0;i--){
					long use = Math.min(remain,pickups[i]);
					remain -= use;
					pickups[i] -= use;
					if(pickups[i]==0) pickUpComplete = i;
					else break;
				}
				answer+=((destination+1)*2);
				destination = Math.max(pickUpComplete-1,delComplete-1);

			}

			return answer;
		}
	}