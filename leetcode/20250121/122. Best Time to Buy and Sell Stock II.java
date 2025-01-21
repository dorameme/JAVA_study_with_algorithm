/*
같은날 푼 문제의 더 쉬운버전 설명 생략
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int b0= -prices[0];
        int s0=0;
        for(int i=1;i<prices.length;i++){
            int tmp= b0;
            b0=Math.max(s0-prices[i],b0);
            s0=Math.max(tmp+prices[i],s0);
        }
        return s0;
    }
}
