class Solution {
    public int solution(int[] stones, int k) {
        // 어차피 모든 돌이 0이하로 되면 건너지못함
        // 따라서 최소 = 1명, 최대 200000으로 지정
        // 이분탐색
        // mid값으로 뺀 배열에 K길이만큼 연속된 0이 있는지 확인
        // 있다면 right = mid-1;
        // 없다면 left = mid+1;
        int max = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]>max)
                max = stones[i];
        }
        int left = 1;
        int right = max;
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(isAvailable(mid,stones,k)){
                answer = mid;
                left=mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return answer+1;
    }
    
    public boolean isAvailable(int mid, int[] stones, int k){
        int cnt = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]-mid<=0){
                cnt++;
            }else{
                cnt = 0;
            }
            
            if(cnt>=k)
                return false;
        }
        
        return true;
    }
}
