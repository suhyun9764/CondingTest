class Solution {
        public int solution(String[] lines) {
            // 끝나는 시간을 기준으로 비교
            // 모든 시간을 ms로 변환
            // 끝나는 시간 ~ 끝나는시간+1000 사이에 시작시간이 들어있는 로그가 몇개인지 세기
            int[] end = new int[lines.length];
            int[] start = new int[lines.length];

            for(int i=0;i<lines.length;i++){
                int endTime = parseEndTime(lines[i]);
                int cost = parseCost(lines[i]);
                int startTime = endTime-cost+1;
                end[i] = endTime;
                start[i] = startTime;
            }

            int max =1;
            for(int i=0;i<end.length-1;i++){
                int currentEndTime =end[i];
                int val = 1;
                for(int j=i+1;j<start.length;j++){
                    int startTime = start[j];
                    if(startTime<=currentEndTime+999){
                        val++;
                    }
                }
                max = Math.max(val,max);
            }

            return max;
        }

        private int parseCost(String line) {
            String[] fields = line.split(" ");
            String costField = fields[2].split("s")[0];
            Double doubleMs = Double.parseDouble(costField);
            return (int)(doubleMs*1000);

        }

        private int parseEndTime(String line) {
            String[] fields = line.split(" ");
            String endField = fields[1];
            String[] split = endField.split("\\.");
            String h = split[0].split(":")[0];
            int hour = Integer.parseInt(h)*60*60*1000;
            String m = split[0].split(":")[1];
            int minute = Integer.parseInt(m)*60*1000;
            String s = split[0].split(":")[2];
            int second = Integer.parseInt(s)*1000;

            String strMs = split[1];
            int ms = Integer.parseInt(strMs);
            return hour+minute+second+ms;
        }
    }