import java.util.*;

class Solution {
        List<Integer> candidates = new ArrayList<>();
            public int solution(String[][] relation) {
                // 0부터 2<<relation[0].length까지 순회
                // 각 비트에 해당하는 자릿수만 sb에 붙혀서 unique, min 검사
                // 통과한건 cadidates에 추가
                int row = relation.length;
                int col = relation[0].length;

                for(int i=1;i<1<<col;i++){
                    Set<String> tuples = new HashSet<>();
                    for(int r=0;r<row;r++){
                        StringBuilder sb = new StringBuilder();
                        for(int c=0;c<col;c++){
                            if((i&(1<<c))!=0){
                                sb.append(relation[r][c]).append("|");
                            }
                        }
                        tuples.add(sb.toString());
                    }

                    if(tuples.size()==row){
                        boolean isMinimum = true;
                        for(int key : candidates){
                            if((key&i)==key){
                                isMinimum = false;
                                break;
                            }
                        }

                        if(isMinimum)
                            candidates.add(i);
                    }
                }

                return candidates.size();
            }

        }