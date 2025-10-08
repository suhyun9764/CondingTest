import java.util.*;

class Solution {

    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> forward = new HashMap<>();
        Map<Integer, Trie> backward = new HashMap<>();

        // 1️⃣ 단어 삽입 (길이별 Trie)
        for (String word : words) {
            int len = word.length();
            forward.putIfAbsent(len, new Trie());
            backward.putIfAbsent(len, new Trie());

            forward.get(len).insert(word);
            backward.get(len).insert(new StringBuilder(word).reverse().toString());
        }

        int[] answer = new int[queries.length];

        // 2️⃣ 쿼리 처리
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            if (!forward.containsKey(len)) {
                answer[i] = 0;
                continue;
            }

            Trie trie;
            String processedQuery;

            if (query.charAt(0) == '?') {
                // 접두가 ? → 역방향 트라이에서 검색
                trie = backward.get(len);
                String reversed = new StringBuilder(query).reverse().toString();
                processedQuery = removeQuestionMark(reversed);
            } else {
                // 접미가 ? → 정방향 트라이에서 검색
                trie = forward.get(len);
                processedQuery = removeQuestionMark(query);
            }

            answer[i] = trie.find(processedQuery);
        }

        return answer;
    }

    // '?' 이전까지만 남기기
    private String removeQuestionMark(String query) {
        int idx = query.indexOf('?');
        if (idx == -1) return query;
        return query.substring(0, idx);
    }
}

class Trie {
    Node root = new Node();

    // 단어 삽입
    public void insert(String word) {
        Node node = root;
        node.count++;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
            node.count++;
        }
    }

    // 접두어 검색
    public int find(String target) {
        if (target.isEmpty()) return root.count; // '?' 전부일 경우
        Node node = root;
        for (char c : target.toCharArray()) {
            if (!node.children.containsKey(c)) return 0;
            node = node.children.get(c);
        }
        return node.count;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    int count = 0;
}
