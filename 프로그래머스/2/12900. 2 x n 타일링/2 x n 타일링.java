class Solution {
    public int solution(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        long a =1;
        long b =2;
        for(int i=3;i<=n;i++){
            long cur = (a+b) % 1000000007;
            a = b;
            b = cur;
        }
        
        return (int)b;
    }
}