import java.util.*;
import java.util.regex.*;

class Page {
        String url;
        int baseScore;
        List<String> links = new ArrayList<>();
        double linkScore; // 소수점 발생 가능

        Page(String url, int baseScore, List<String> links) {
            this.url = url;
            this.baseScore = baseScore;
            this.links = links;
        }
    }

     class Solution {
        public int solution(String word, String[] pages) {
            word = word.toLowerCase(); // 검색어 소문자화
            Map<String, Page> map = new HashMap<>();
            String[] urls = new String[pages.length];

            // 1. 파싱
            for (int i = 0; i < pages.length; i++) {
                String page = pages[i];
                String url = getUrl(page);
                String body = getBody(page);
                int baseScore = getBaseScore(body, word);
                List<String> links = getLinks(body);
                Page p = new Page(url, baseScore, links);
                map.put(url, p);
                urls[i] = url;
            }

            // 2. 링크 점수 분배
            for (Page p : map.values()) {
                if (p.links.isEmpty()) continue;
                double share = (double) p.baseScore / p.links.size();
                for (String link : p.links) {
                    Page target = map.get(link);
                    if (target != null) {
                        target.linkScore += share;
                    }
                }
            }

            // 3. 최대 매칭 점수 찾기
            int answer = 0;
            double maxScore = -1;
            for (int i = 0; i < urls.length; i++) {
                Page p = map.get(urls[i]);
                double total = p.baseScore + p.linkScore;
                if (total > maxScore) {
                    maxScore = total;
                    answer = i;
                }
            }
            return answer;
        }

       private String getUrl(String page) {
    Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"");
    Matcher matcher = pattern.matcher(page);
    if (matcher.find()) {
        return matcher.group(1);
    }
    return "";
}


        private String getBody(String page) {
            int start = page.toLowerCase().indexOf("<body>");
            int end = page.toLowerCase().indexOf("</body>");
            return page.substring(start + 6, end);
        }

       private static int getBaseScore(String body, String word) {
    String[] words = body.replaceAll("<[^>]+>", " ")
                         .toLowerCase()
                         .split("[^a-z]+");
    int score = 0;
    for (String w : words) {
        if (!w.isEmpty() && w.equals(word)) score++;
    }
    return score;
}

        private List<String> getLinks(String body) {
            List<String> links = new ArrayList<>();
            Pattern pattern = Pattern.compile("(?i)<a href=\"(.*?)\"");
            Matcher matcher = pattern.matcher(body);
            while (matcher.find()) {
                links.add(matcher.group(1));
            }
            return links;
        }
    }