/*
start:12:00
end:12:19
시간복잡도:O(N)
공간복잡도:O(1)
풀이: dp 로 푸는문제였는데 사실상 공간할당 없이 이전값만 담을 수 있으면 된다!!
*/
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        int s=0;
        int b =-prices[0];
        for(int i=1;i<prices.length;i++){
            s= Math.max(s, b+prices[i]);
            b= Math.max(b, s-prices[i]);
        }
        return s;
    }
}
