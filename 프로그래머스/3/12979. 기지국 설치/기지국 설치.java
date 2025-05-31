class Solution {
    public int solution(int n, int[] stations, int w) {
        int emptyStart = 1;
        int answer = 0;

        for (int station : stations) {
            int stationStart = Math.max(1, station - w);
            int stationEnd = Math.min(n, station + w);

            int totalEmpty = stationStart - emptyStart;
            if (totalEmpty > 0) {
                answer += (totalEmpty + 2 * w) / (2 * w + 1);
            }

            emptyStart = stationEnd + 1;
        }

        // 마지막 기지국 이후 남은 구간
        if (emptyStart <= n) {
            int totalEmpty = n - emptyStart + 1;
            answer += (totalEmpty + 2 * w) / (2 * w + 1);
        }

        return answer;
    }
}
