import java.util.*;

class Solution {
    List<String> route = new ArrayList<>();
    boolean[] visited;
    String[] answer;
    boolean found = false;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        visited = new boolean[tickets.length];
        route.add("ICN");
        dfs("ICN", tickets, 0);
        return answer;
    }

    private void dfs(String current, String[][] tickets, int depth) {
        if (found) return;

        if (depth == tickets.length) {
            answer = route.toArray(new String[0]);
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, depth + 1);
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}
