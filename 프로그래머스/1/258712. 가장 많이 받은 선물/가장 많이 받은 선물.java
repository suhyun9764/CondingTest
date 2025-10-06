import java.util.*;

class Solution {
		int[][] giftHistory;
		int[] giftRate;
		Map<String,Integer> userMap = new HashMap<>();
		public int solution(String[] friends, String[] gifts) {

			for(int i=0;i< friends.length;i++){
				userMap.put(friends[i],i);
			}
			giftRate = new int[friends.length];
			giftHistory = new int[friends.length][friends.length];

			for(int i=0;i<gifts.length;i++){
				String user1 =  gifts[i].split(" ")[0];
				String user2 =  gifts[i].split(" ")[1];

				giftHistory[userMap.get(user1)][userMap.get(user2)]++;
			}

			for(int i=0;i<friends.length;i++){
				int give = 0;
				int get = 0;
				for(int j=0;j<friends.length;j++){
					if(i==j) continue;
					give+=giftHistory[i][j];
					get+=giftHistory[j][i];
				}
				giftRate[i] = give-get;
			}

			int[] getGiftArray = new int[friends.length];

			for(int i=0;i<friends.length;i++){
				for(int j=i;j<friends.length;j++){
					if(i==j) continue;
					int give = giftHistory[i][j];
					int get = giftHistory[j][i];

					if(give>get){
						getGiftArray[i]++;
					}

					if(give<get){
						getGiftArray[j]++;
					}

					if(give==get){
						int iRate = giftRate[i];
						int jRate = giftRate[j];

						if(iRate==jRate) continue;
						if(iRate>jRate){
							getGiftArray[i]++;
						}
						if(iRate<jRate){
							getGiftArray[j]++;
						}
					}
				}
			}

			Arrays.sort(getGiftArray);
			return getGiftArray[getGiftArray.length-1];
		}
	}