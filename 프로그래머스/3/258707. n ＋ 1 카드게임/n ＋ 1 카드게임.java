import java.util.*;

class Solution {
		public int solution(int coin, int[] cards) {
			int target = cards.length+1;
			Set<Integer> hand = new HashSet<>();
			Set<Integer> pocket = new HashSet<>();
			for(int i=0;i<cards.length/3;i++){
				hand.add(cards[i]);
			}

			int round = 1;
			int cardIndex = cards.length/3;
			while (cardIndex<cards.length){
				pocket.add(cards[cardIndex]);
				pocket.add(cards[cardIndex+1]);
				cardIndex+=2;

				// 손에서만 가능한면 손에서 해결
				Integer pair = findInHand(hand,target);
				if(pair!=null){
					hand.remove(pair);
					hand.remove(target-pair);
					round++;
					continue;
				}

				Integer handPair = findInBoth(hand,pocket,target);
				if(handPair!=null&&coin>=1){
					coin--;
					hand.remove(handPair);
					pocket.remove(target-handPair);
					round++;
					continue;
				}

				Integer pocketPair = findInPocket(pocket,target);
				if(pocketPair!=null&&coin>=2){
					coin-=2;
					pocket.remove(pocketPair);
					pocket.remove(target-pocketPair);
					round++;
					continue;
				}

				break;

				// 손 1장 주어진거 1장으로 해결
				// 손에서불가능하다면 2장 가져오기
			}
			return round;
		}

		private Integer findInHand(Set<Integer> hand, int target) {
			ArrayList<Integer> cards = new ArrayList<>(hand);
			for(int i=0;i<cards.size();i++){
				int curCard = cards.get(i);
				if(hand.contains(target-curCard)){
					return curCard;
				}
			}
			return null;
		}

		private Integer findInBoth(Set<Integer> hand, Set<Integer> pocket, int target) {
			ArrayList<Integer> pocketCards = new ArrayList<>(pocket);
			ArrayList<Integer> handCards = new ArrayList<>(hand);

			for(int i=0;i<handCards.size();i++){
				int curCard = handCards.get(i);
				if(pocket.contains(target-curCard)){
					return curCard;
				}
			}
			return null;
		}

		private Integer findInPocket(Set<Integer> pocket, int target) {
			ArrayList<Integer> cards = new ArrayList<>(pocket);
			for(int i=0;i<cards.size();i++){
				int curCard = cards.get(i);
				if(pocket.contains(target-curCard)){
					return curCard;
				}
			}
			return null;
		}
	}