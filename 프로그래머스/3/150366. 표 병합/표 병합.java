import java.util.*;

class Solution {
		/*

           3. merge r1 c1 r2 c2 :
           		- r1, c1위치의 셀과 r2,c2의 셀 병합
           		- 둘다 값을 가지고 잇다면 처음값
           		- 하나만 가지고 있다면 해당 값
           		- 만약 위치 좌표가 같다면 무시
           		- 이후 어느 위치를 선택하여도 병합된 셀로 접근
           	4. unmerge r c
           		- 해당 셀의 모든 병합 해제
           		- 셀이 값이 있을경우 r,c가 해당값 가짐
           	5. print r c
           		- r,c위치 셀  출력
           		- 없다면 EMPTY

		 */
		int[] parent = new int[51*51];
		String[] values = new String[51*51];
		List<String> printList = new ArrayList<>();
		public String[] solution(String[] commands) {
			for(int i=1;i<parent.length;i++){
				parent[i] = i;
			}
			for(int i=0;i<commands.length;i++){
				execute(commands[i]);
			}

			String[] answer = new String[printList.size()];
			for(int i=0;i<answer.length;i++){
				answer[i] = printList.get(i);
			}
			return answer;
		}

		private void execute(String command) {
			String[] fields = command.split(" ");
			String action = fields[0];
			String details = "";
			for(int i=1;i<fields.length;i++){
				details +=fields[i]+" ";
			}

			if(action.equals("UPDATE")){
				update(details);
			}

			if(action.equals("MERGE")){
				merge(details);
			}

			if(action.equals("UNMERGE")){
				unmerge(details);
			}

			if(action.equals("PRINT")){
				print(details);
			}

		}

		private void update(String details) {
			/*
			  1. update r c value : r,c 위치 value로 변경
              2. update value1 value2 : value1값 value2로 변경
			 */
			String[] fields = details.split(" ");
			if(fields.length==3){
				int r = Integer.parseInt(fields[0]);
				int c = Integer.parseInt(fields[1]);
				String value = fields[2];
				int index = toIndex(r,c);
				int parent = findParent(index);
				values[parent] = value;
			}
			if(fields.length==2){
				String target = fields[0];
				String newValue = fields[1];

				for(int i=0;i<values.length;i++){
					if(values[i]==null) continue;
					if(values[i].equals(target))
						values[i] = newValue;
				}
			}
		}

		private int toIndex(int r, int c) {
			return (r-1)*50+(c-1);
		}

		private void merge(String details) {
			String[] fields = details.split(" ");
			int y1 = Integer.parseInt(fields[0]);
			int x1 = Integer.parseInt(fields[1]);
			int y2 = Integer.parseInt(fields[2]);
			int x2 = Integer.parseInt(fields[3]);

			int firstIndex = toIndex(y1,x1);
			int secondIndex = toIndex(y2,x2);

			int firstParent = findParent(firstIndex);
			int secondParent = findParent(secondIndex);

			if(firstParent==secondParent) return;

			String value = values[firstParent];
			if(value==null){
				value = values[secondParent];
			}

			values[firstParent] = value;
			values[secondParent] = null;

			parent[secondParent] = firstIndex;
		}

		private int findParent(int firstIndex) {
			if(parent[firstIndex]==firstIndex) return firstIndex;

			return findParent(parent[firstIndex]);
		}

		private void unmerge(String details) {
			int y = Integer.parseInt(details.split(" ")[0]);
			int x = Integer.parseInt(details.split(" ")[1]);

			int index = toIndex(y, x);
			int curParent = findParent(index);
			String value = values[curParent];
			List<Integer> children = new ArrayList<>();
			for(int i=0;i<parent.length;i++){
				int root = findParent(parent[i]);
				if(root==curParent){
					children.add(i);
				}
			}

			for(int i=0;i<children.size();i++){
				Integer child = children.get(i);
				parent[child] = child;
				values[child] = null;
			}
			values[index] = value;
		}

		private void print(String details) {
			int y = Integer.parseInt(details.split(" ")[0]);
			int x = Integer.parseInt(details.split(" ")[1]);

			int index = toIndex(y, x);
			int curParent = findParent(index);
			String value = values[curParent];

			if(value==null) value = "EMPTY";
			printList.add(value);

		}
	}