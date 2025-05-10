class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] map = new int[n][m];
            for (int[] puddle : puddles) {
                int puddleM = puddle[0]-1;
                int puddleN = puddle[1]-1;
                map[puddleN][puddleM] = -1;
            }

            for(int i=0;i<n;i++){
                if(map[i][0]==-1)
                    break;
                map[i][0] = 1;
            }

            for(int i=0;i<m;i++){
                if(map[0][i]==-1)
                    break;
                map[0][i] = 1;
            }

            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    long buffer = 0;
                    if(map[i][j]==-1)
                        continue;
                    if(map[i-1][j]!=-1){
                        buffer += map[i-1][j];
                    }

                    if(map[i][j-1]!=-1){
                        buffer +=map[i][j-1];
                    }
                    map[i][j] = (int)buffer%1000000007;
                }
            }

            return map[n-1][m-1];
        }
    }