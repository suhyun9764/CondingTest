import java.util.*;

class Solution {

		int[][] users;
		int[] emoticons;
		int[] rate = {40,30,20,10};
		int emPlusCnt = 0;
		int emSalePrice = 0;
		public int[] solution(int[][] users, int[] emoticons) {
			this.users = users;
			this.emoticons = emoticons;
			dfs(0,new int[emoticons.length]);
			return new int[]{emPlusCnt,emSalePrice};

		}

		private void dfs(int i, int[] curRates) {
			if(i==emoticons.length){
				sale(curRates);
				return;
			}

			for(int r=0;r<4;r++){
				int curRate = rate[r];
				curRates[i] = curRate;
				dfs(i+1,curRates);
			}
		}

		private void sale(int[] curRates) {
			int curEmPlusCnt = 0;
			int curEmSalePrice = 0;

			for(int i=0;i< users.length;i++){
				int userWantMinRate = users[i][0];
				int userCanUse = users[i][1];

				int buyAmount = 0;
				for(int e=0;e< emoticons.length;e++){
					if(curRates[e]<userWantMinRate) continue;
					int discountedPrice = emoticons[e]/100*(100-curRates[e]);
					buyAmount+=discountedPrice;
				}

				if(buyAmount>=userCanUse){
					curEmPlusCnt++;
				}else{
					curEmSalePrice+=buyAmount;
				}
			}

			if(emPlusCnt<curEmPlusCnt){
				emPlusCnt = curEmPlusCnt;
				emSalePrice = curEmSalePrice;
			}else if(emPlusCnt==curEmPlusCnt){
				emSalePrice = Math.max(emSalePrice,curEmSalePrice);
			}
		}
	}