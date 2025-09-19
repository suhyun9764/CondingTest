import java.util.*;

class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            // 키 시계방향으로 90, 180, 270도 돌리고 각각 순회
            // 키왼쪽 맨 밑 모서리가 자물쇠의 최상단 오른쪽에 닿을때부터 끝까지 순회

            List<int[][]> keys = new ArrayList<>();
            keys = getKeys(key);


            for(int[][] curKey : keys){
                if(match(lock,curKey))
                    return true;
            }
            return false;
        }

        private boolean match(int[][] lock, int[][] curKey) {
            int ll = lock.length;
            int cl = curKey.length;
            boolean result = false;
            for(int i=0;i<ll+cl;i++){
                for(int j=0;j<ll+cl;j++){
                    int yDiff = cl-i-1;
                    int xDiff = cl-j-1;
                    boolean isMatch = true;
                    int[][] tmp = new int[ll][ll];
                    for(int t=0;t<ll;t++){
                        tmp[t] = Arrays.copyOf(lock[t],ll);
                    }
                    for(int ki=0;ki<cl;ki++){
                        for(int kj=0;kj<cl;kj++){
                            int curY = ki-yDiff;
                            int curX= kj-xDiff;
                            if(curX<0||curX>=ll||curY<0||curY>=ll) continue;
   if(curKey[ki][kj]!=lock[curY][curX]){
                                tmp[curY][curX] = 1;
                            }else{
                                tmp[curY][curX] = 0;
                            }
                        }
                    }
                    boolean isAllOne = true;
                    for(int a=0;a<ll;a++){
                        for(int b=0;b<ll;b++){
                            if(tmp[a][b]==0){
                                isAllOne = false;
                                break;
                            }
                        }
                    }

                    if(isAllOne){
                        result = true;
                        break;
                    }
                }
            }

            return result;
        }

        private List<int[][]> getKeys(int[][] key) {
            List<int[][]> list = new ArrayList<>();
            list.add(key);

            for(int i=0;i<3;i++){
                key = turnKey(key);
                list.add(key);
            }

            return list;
        }

        private int[][] turnKey(int[][] key) {
            int n = key.length;
            int[][] tmp = new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int cur = key[i][j];
                    tmp[j][n-1-i] = cur;
                }
            }

            return tmp;
        }
    }