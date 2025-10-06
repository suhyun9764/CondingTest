import java.util.*;

class Solution {
        public int solution(int coin, int[] cards) {
            int n = cards.length;
            int target = n + 1;
            
            // 초기 손패
            Set<Integer> hand = new HashSet<>();
            for (int i = 0; i < n / 3; i++) {
                hand.add(cards[i]);
            }
            
            // 뽑은 카드 보관소
            Set<Integer> picked = new HashSet<>();
            
            int round = 1;
            int cardIndex = n / 3;
            
            while (cardIndex < n) {
                // 2장 뽑기
                picked.add(cards[cardIndex]);
                picked.add(cards[cardIndex + 1]);
                cardIndex += 2;
                
                boolean canContinue = false;
                
                // 1. 손패에서만 페어를 만들 수 있는 경우 (코인 0개)
                Integer pair = findPairInSet(hand, target);
                if (pair != null) {
                    hand.remove(pair);
                    hand.remove(target - pair);
                    canContinue = true;
                }
                // 2. 손패 1장 + picked 1장으로 페어 (코인 1개)
                else if (coin >= 1) {
                    pair = findPairBetweenSets(hand, picked, target);
                    if (pair != null) {
                        hand.remove(pair);
                        picked.remove(target - pair);
                        coin--;
                        canContinue = true;
                    }
                    // 3. picked에서만 페어를 만들 수 있는 경우 (코인 2개)
                    else if (coin >= 2) {
                        pair = findPairInSet(picked, target);
                        if (pair != null) {
                            picked.remove(pair);
                            picked.remove(target - pair);
                            coin -= 2;
                            canContinue = true;
                        }
                    }
                }
                
                if (!canContinue) {
                    break;
                }
                
                round++;
            }
            
            return round;
        }
        
        // 한 세트 내에서 페어 찾기
        private Integer findPairInSet(Set<Integer> set, int target) {
            for (int card : set) {
                if (set.contains(target - card)) {
                    return card;
                }
            }
            return null;
        }
        
        // 두 세트 사이에서 페어 찾기
        private Integer findPairBetweenSets(Set<Integer> set1, Set<Integer> set2, int target) {
            for (int card : set1) {
                if (set2.contains(target - card)) {
                    return card;
                }
            }
            return null;
        }
    }