import java.util.*;

class Solution {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> lineNumber = new HashMap<>();
		int[] answer = new int[4];

		public int[] solution(int[][] edges) {
			int root = 0;
			for (int i = 0; i < edges.length; i++) {
				map.putIfAbsent(edges[i][0], new ArrayList<>());
				map.get(edges[i][0]).add(edges[i][1]);
				if(map.get(edges[i][0]).size()>=2) root = edges[i][0];
				lineNumber.put(edges[i][1], lineNumber.getOrDefault(edges[i][1], 0) + 1);
			}

			answer[0] = root;

			Set<Integer> visited = new HashSet<>();
			visited.add(root);
			List<Integer> children = map.get(root);
			for (int child : children) {
				visited.add(child);
				dfs(child, visited, 0, 0);
			}

			return answer;
		}

		private void dfs(int root, Set<Integer> visited, int edgeCnt, int lineCnt) {
			edgeCnt++;
			List<Integer> children = map.get(root);
			if(children!=null) lineCnt+=children.size();

			boolean canMove = false;
			List<Integer> child = map.get(root);
			if (child!=null) {
				if (!visited.contains(child.get(0))) {
					canMove = true;
					visited.add(child.get(0));
					dfs(child.get(0), visited, edgeCnt, lineCnt);
				}
			}

			if (canMove == false) {
				if (edgeCnt == lineCnt) {
					answer[1]++;
					return;
				}

				if (edgeCnt - 1 == lineCnt) {
					answer[2]++;
					return;
				}

				answer[3]++;
			}
		}
	}