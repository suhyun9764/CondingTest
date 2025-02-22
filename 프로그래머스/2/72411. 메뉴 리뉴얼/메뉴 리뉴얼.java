
import java.util.*;

class Solution {
        static String[] answer;
        static List<String> selectedMenuCombines = new ArrayList<>();
        public String[] solution(String[] orders, int[] course) {
            // course 순회
            for (int menuNumber : course) {
                // orders 순회
                HashMap<String, Integer> menuCombinesMap = new HashMap<>();
                for (String order : orders) {
                    // 각 course의 메뉴 수만큼 각 order에서 조합하여 map에 <메뉴조합 문자열, 횟수> 저장하기
                    menuCombinesMap = getCombineResult(order,menuCombinesMap,menuNumber);
                }
                // map 순회하며 우선순위 큐에 횟수순대로 저장하기
                PriorityQueue<MenuCombine> queue = new PriorityQueue<>((a,b)->b.num-a.num);
                for (Map.Entry<String, Integer> menuCombine : menuCombinesMap.entrySet()) {
                    queue.add(new MenuCombine(menuCombine.getKey(),menuCombine.getValue()));
                }
                // 큐에서 가장 처음꺼를 꺼내고 그것과 같은 횟수의 메뉴조합을 answer에 저장
                // 단 주문횟수가 2번이상만
                if(queue.isEmpty()) continue;
                MenuCombine menuCombine = queue.poll();
                int maxNumber = menuCombine.num;
                if(maxNumber>=2){
                    selectedMenuCombines.add(menuCombine.menus);
                    while (!queue.isEmpty()&&queue.peek().num==maxNumber){
                        selectedMenuCombines.add(queue.poll().menus);
                    }
                }
            }

            Collections.sort(selectedMenuCombines);
            answer = new String[selectedMenuCombines.size()];
            for(int i=0;i<answer.length;i++){
                answer[i] = selectedMenuCombines.get(i);
            }

            return answer;
        }

        private HashMap<String, Integer> getCombineResult(String order, HashMap<String, Integer> menuCombinesMap, int menuNumber) {
            char[] charArray = order.toCharArray();
            Arrays.sort(charArray);
            combine(charArray,new StringBuilder(),0,menuCombinesMap,menuNumber);
            return menuCombinesMap;
        }

        private void combine(char[] charArray, StringBuilder sb, int start,HashMap<String, Integer> menuCombinesMap, int menuNumber) {
            if(sb.length()==menuNumber){
                String menuCombine = sb.toString();
                menuCombinesMap.put(menuCombine,menuCombinesMap.getOrDefault(menuCombine,0)+1);
                return;
            }
            for(int i=start;i<charArray.length;i++){
                sb.append(charArray[i]);
                combine(charArray, sb,i+1,menuCombinesMap, menuNumber);
                sb.deleteCharAt(sb.length()-1);
            }
        }

        static class MenuCombine{
            String menus;
            int num;

            public MenuCombine(String menus, int num) {
                this.menus = menus;
                this.num = num;
            }
        }
    }
