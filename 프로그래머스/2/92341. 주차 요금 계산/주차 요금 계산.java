import java.util.*;

class Car{
        String number;
        int totalCost;

        public Car(String number, int totalCost) {
            this.number = number;
            this.totalCost = totalCost;
        }
    }

 class Solution {
        int defaultTime;
        int defaultCost;
        int unitMinute;
        int unitCost;

        public int[] solution(int[] fees, String[] records) {
            // 1. 요금 분리
            extractFees(fees);
            // 2. map만들어서 시간 관리
            Map<String,Integer> timeMap = new HashMap<>();
            // 3. map만들어서 입차시간 관리
            Map<String,Integer> inMinuteMap = new HashMap<>();
            // 4. In인 경우 map에 저장, out인 경우 map에 저장된 입차 시간을 빼서 요금 계산
            for(String record : records){
                String[] fields = record.split(" ");
                int minute = toMinute(fields[0]);
                String carNumber = fields[1];
                String action = fields[2];

                if(action.equals("IN")){
                    inMinuteMap.put(carNumber,minute);
                }

                if(action.equals("OUT")){
                    int inMinute = inMinuteMap.get(carNumber);
                    timeMap.put(carNumber,timeMap.getOrDefault(carNumber,0)+minute-inMinute);
                    inMinuteMap.put(carNumber,-1);
                }
            }
            // 5. map순회하여 남은 차량이 있다면 23:59분 기준으로 계산
            Car[] cars = new Car[inMinuteMap.size()];
            int index = 0;
            for(Map.Entry<String,Integer> entry : inMinuteMap.entrySet()){
                String carNumber = entry.getKey();
                if(entry.getValue()!= -1){
                    int inMinute = inMinuteMap.get(carNumber);
                    int outMinute = toMinute("23:59");
                    timeMap.put(carNumber,timeMap.getOrDefault(carNumber,0)+outMinute-inMinute);
                }
                int totalCost = calculateFee(timeMap.get(carNumber));
                cars[index++] = new Car(carNumber,totalCost);
            }

            Arrays.sort(cars,(a,b)->{
                return a.number.compareTo(b.number);
            });

            int[] answer = new int[cars.length];
            for(int i=0;i<answer.length;i++){
                answer[i] = cars[i].totalCost;
            }
            return answer;
        }

        private Integer calculateFee(int useTime) {
            int total = defaultCost;
            if(useTime>defaultTime){
                useTime = useTime-defaultTime;
                int n = useTime/unitMinute;
                if(useTime%unitMinute!=0){
                    n+=1;
                }
                total += n*unitCost;
            }

            return total;
        }

        private int toMinute(String time) {
            String[] fields = time.split(":");
            int hour = Integer.parseInt(fields[0])*60;
            int minute = Integer.parseInt(fields[1]);

            return hour+minute;
        }

        private void extractFees(int[] fees) {
            defaultTime = fees[0];
            defaultCost = fees[1];
            unitMinute = fees[2];
            unitCost = fees[3];
        }
    }