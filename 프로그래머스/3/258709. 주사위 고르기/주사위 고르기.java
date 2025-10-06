import java.util.*;

class Solution {
        int A = 0;
        int B = 1;
        int N;
        int[] owner;
        int maxWin = 0;
        int[] answer;
        int num2=0;
        int diceCnt = 0;
        int[][] dice;
        List<Integer> bResult = new ArrayList<>();
        public int[] solution(int[][] dice) {
            this.dice = dice;
            diceCnt = dice.length;
            N = diceCnt /2;
            owner = new int[diceCnt +1];

            // B가 주사위 들고가기
            dfs(1,0);
            System.out.println(num2);
            return answer;
        }

        private void dfs(int num, int depth) {
            if(depth==N){
                this.num2++;
                calculateResult(owner);
                return;
            }
            if(num>diceCnt)
                return;

            owner[num] = 1;
            dfs(num+1,depth+1);
            owner[num] = 0;
            dfs(num+1,depth);
        }

        private void calculateResult(int[] owner) {
            int[] aDice = new int[N];
            int[] bDice = new int[N];

            int aIndex = 0;
            int bIndex = 0;
            for(int i=1;i<owner.length;i++){
                if(owner[i]==0){
                    aDice[aIndex++] = i;
                    continue;
                }

                bDice[bIndex++] = i;
            }
            bResult = new ArrayList<>();
            bdfs(0,bDice,0);
            Collections.sort(bResult);
            int winCnt = diceDfs(0,aDice,0,0);
            if(maxWin<winCnt){
                maxWin = winCnt;
                answer = aDice;
            }
        }

        private void bdfs(int depth, int[] bDice, int sum) {
            if(depth==N){
                bResult.add(sum);
                return;
            }

            int[] curDice = dice[bDice[depth]-1];
            for(int i=0;i<6;i++){
                bdfs(depth+1,bDice,sum+curDice[i]);
            }

        }

        private int diceDfs(int depth, int[] aDice, int sum, int winCnt) {
            if(depth==N){
                winCnt+=getWinCnt(sum);
                return winCnt;
            }
            int[] curDice = dice[aDice[depth]-1];
            for(int i=0;i<6;i++){
                winCnt= diceDfs(depth+1,aDice,sum+curDice[i],winCnt);
            }

            return winCnt;
        }

        private int getWinCnt(int sum) {
            int left = 0;
            int right = bResult.size();

            while (left<right){
                int mid = (left+right)/2;
                if(bResult.get(mid)>=sum){
                    right = mid;
                }else
                    left = mid+1;
            }

            return left;
        }
    }