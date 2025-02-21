class Solution {
        static boolean[] hasLate;
        static int employeeNumber;
        static int latePersonNumber = 0;
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            employeeNumber = schedules.length;
            hasLate = new boolean[employeeNumber];

            int dayNum = 1;
            int currentDay = startday;

            // 5일(평일만 순회)
            checkAllEmployeeIsLate(schedules, timelogs, dayNum, currentDay);
            return employeeNumber-latePersonNumber;
        }

        private void checkAllEmployeeIsLate(int[] schedules, int[][] timelogs, int dayNum, int currentDay) {
            int todayScheduleIdx = 0;
            while(dayNum <6){
                // 주말이면 스킵
                // 해당 요일의 모든 직원의 출근 시간 확인
                if(currentDay<=5){
                    for(int i=0;i<employeeNumber;i++){
                        // 해당 요일의 i직원 지각 여부 체크
                        if(hasLate[i])
                            continue;
                        checkIsLate(i, schedules, timelogs,todayScheduleIdx);
                    }
                    dayNum++;
                }


                currentDay++;
                if(currentDay>7){
                    currentDay%=7;
                }
                todayScheduleIdx++;

            }
        }

        private void checkIsLate(int i, int[] schedules, int[][] timelogs, int todayScheduleIdx) {
            int expectTotalMinute = getTotalMinute(schedules[i]);
            int realTotalMinute = getTotalMinute(timelogs[i][todayScheduleIdx]);

            if(realTotalMinute-expectTotalMinute>10) {
                hasLate[i] = true;
                latePersonNumber++;
            }
        }

        private static int getTotalMinute(int time) {
            int expectHour = time/100;
            int expectMinute = time%100;
            return expectHour*60+expectMinute;
        }
    }