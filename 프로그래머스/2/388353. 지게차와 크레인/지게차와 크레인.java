import java.util.*;

class Solution {
        static Map<Character, List<int[]>> map = new HashMap<>();
        static char[][] storageMap;
        static int Y, X;
        static boolean[][] isEmpty;
        static int[] dy = {-1,1,0,0};
        static int[] dx = {0,0,-1,1};
        static int outNumber = 0;

        public int solution(String[] storage, String[] requests) {
            // 요청이 들어온 알파벳만 추출
            makeMap(requests);
            // 창고 정보 저장
            makeStorageMap(storage);
            // 요청될 알파벳의 위치정보 저장
            fillMap();
            // 요청 순회
            isEmpty = new boolean[Y][X];
            for (String request : requests) {
                // 1글자 인경우 -> 외부와 연결된 경우만 빼기
                char alphabet = request.charAt(0);
                List<int[]> locations = map.get(alphabet);
                List<int[]> outLocations = new ArrayList<>();
                if (request.length() == 1) {
                    for (int[] location : locations) {
                        int y = location[0];
                        int x = location[1];
                        if(isEmpty[y][x]) continue; // 이미 비워진건 스킵
                        for(int d=0;d<4;d++){   // 사방 탐색
                            int ny = y+dy[d];
                            int nx = x+dx[d];
                            if(ny<0||nx<0||ny>=Y||nx>=X){
                                outLocations.add(new int[]{y,x});
                                break;
                            }else if(checkLinkWithOut(y,x)){    // 더 깊은 탐색
                                outLocations.add(new int[]{y,x});
                                break;
                            }
                        }

                    }
                    // 2글자 인경우 -> 해당 알파벳 다 빼기
                } else {
                    for (int[] location : locations) {
                        int y = location[0];
                        int x = location[1];
                         if (isEmpty[y][x]) continue;
                        outLocations.add(new int[]{y,x});
                    }
                }
                for (int[] outLocation : outLocations) {
                    isEmpty[outLocation[0]][outLocation[1]] = true;
                    outNumber++;
                }
            }

            return X*Y-outNumber;
        }

        private boolean checkLinkWithOut(int y, int x) {
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{y,x});
            boolean[][] visit = new boolean[Y][X];
            while (!queue.isEmpty()){
                int[] current = queue.poll();
                for(int d=0;d<4;d++){
                    int ny = current[0]+dy[d];
                    int nx = current[1]+dx[d];
                    if(ny<0||nx<0||ny>=Y||nx>=X){
                        return true;
                    }
                    if(isEmpty[ny][nx]&&!visit[ny][nx]) {
                        queue.offer(new int[]{ny, nx});
                        visit[ny][nx] = true;
                    }
                }
            }
            return false;
        }

        private void fillMap() {
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    char alphabet = storageMap[i][j];
                    if (map.containsKey(alphabet)) {
                        map.get(alphabet).add(new int[]{i, j});
                    }
                }
            }
        }

        private void makeStorageMap(String[] storage) {
            Y = storage.length;
            X = storage[0].length();
            storageMap = new char[Y][X];
            for (int i = 0; i < Y; i++) {
                storageMap[i] = storage[i].toCharArray();
            }
        }

        private void makeMap(String[] requests) {
            for (String request : requests) {
                char alphabet = request.charAt(0);
                if (!map.containsKey(alphabet)) {
                    map.put(alphabet, new ArrayList<>());
                }
            }
        }
    }
