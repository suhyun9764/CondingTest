import java.util.*;

class Solution {
        Map<String, List<Integer>> map = new HashMap<>();

        public int[] solution(String[] info, String[] query) {
            // 1. info → 모든 조합을 key로 저장
            for (String s : info) {
                String[] split = s.split(" ");
                String[] conditions = new String[]{split[0], split[1], split[2], split[3]};
                int score = Integer.parseInt(split[4]);

                // 16가지 경우의 수 (- 포함)
                dfs(conditions, 0, "", score);
            }

            // 2. 각 리스트 정렬 (이분 탐색을 위해)
            for (List<Integer> list : map.values()) {
                Collections.sort(list);
            }

            // 3. query 처리
            int[] answer = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                String q = query[i].replaceAll(" and ", " ");
                String[] split = q.split(" ");
                String key = split[0] + split[1] + split[2] + split[3];
                int score = Integer.parseInt(split[4]);

                if (!map.containsKey(key)) {
                    answer[i] = 0;
                    continue;
                }

                List<Integer> list = map.get(key);
                int idx = lowerBound(list, score);
                answer[i] = list.size() - idx;
            }

            return answer;
        }

        // DFS로 조합 생성
        private void dfs(String[] arr, int depth, String key, int score) {
            if (depth == 4) {
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                return;
            }
            // 현재 조건 선택
            dfs(arr, depth + 1, key + arr[depth], score);
            // "-" 선택
            dfs(arr, depth + 1, key + "-", score);
        }

        // lower bound (score 이상인 첫 위치 찾기)
        private int lowerBound(List<Integer> list, int target) {
            int left = 0, right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) >= target) right = mid;
                else left = mid + 1;
            }
            return left;
        }
    }