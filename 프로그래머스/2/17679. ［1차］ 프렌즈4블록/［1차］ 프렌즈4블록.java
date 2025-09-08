import java.util.*;

class Solution {
        int[] dy = {0,1,1};
        int[] dx = {1,0,1};

        public int solution(int m, int n, String[] board) {
            // 2*2 로 탐색 반복
            // delete[] 만들어 삭제해야할 항목 체크
            // answer에 체크된 내용 만큼 더하고, board에서 삭제
            // 맨밑에서부터 순회하여 빈공간이 있다면 위로부터 가장 가까이 있는 블록 내리기
            // 반복하다가 삭제해야될게 0이라면 break
            char[][] arr = new char[m][n];
            for(int i=0;i<m;i++){
                arr[i] = board[i].toCharArray();
                // System.out.println(Arrays.toString(arr[i]));
            }

            int answer = 0;
            while(true){
                boolean[][] delete = new boolean[m][n];
                int thisTurnDelete = 0;
                for(int i=0;i<m-1;i++){
                    for(int j=0;j<n-1;j++){
                        boolean isFour = true;
                        char c = arr[i][j];
                        if(c=='0') continue;
                        for(int d=0;d<3;d++){
                            int ny = i+dy[d];
                            int nx = j+dx[d];
                            if(arr[ny][nx]!=c){
                                isFour = false;
                                break;
                            }
                        }
                        if(isFour){
                            if(!delete[i][j]){
                                answer++;
                                thisTurnDelete++;
                            }
                            delete[i][j] = true;
                            for(int d=0;d<3;d++){
                                int ny = i+dy[d];
                                int nx = j+dx[d];
                                if(!delete[ny][nx]) {
                                    answer++;
                                    thisTurnDelete++;
                                }
                                delete[ny][nx] = true;
                            }
                        }

                    }
                }

                if(thisTurnDelete==0) break;
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if(delete[i][j]){
                            arr[i][j] = '0';
                        }
                    }
                }

                for(int i=m-1;i>0;i--){
                    for(int j=0;j<n;j++){
                        if(arr[i][j]=='0'){
                            int up = i-1;
                            while(up>0&&arr[up][j]=='0'){
                                up--;
                            }

                            if(arr[up][j]!='0'){
                                arr[i][j] = arr[up][j];
                                arr[up][j] = '0';
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }