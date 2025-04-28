/*
start:16:00
end:16:23
시간복잡도:O(N)
공간복잡도:O(1)
풀이:
~지금 가격이 산 가격보다 비싸면~
➔ 바로 이득을 보고 판다.
→ 수익 have += prices[i] - buy 추가하고,
→ 다시 buy = prices[i]로 업데이트한다. (새로 샀다고 가정)
~ 가격이 더 싸면 ~
더 싼 가격을 찾아서 buy를 업데이트한다.
➔ 즉, 나중에 팔아서 이득을 더 크게 만들려고 한다.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int buy = prices[0];
        int have=0;
        for(int i=1;i<len;i++){
            if( prices[i]>buy){
                have += prices[i]-buy;  // 이득을 볼수있으면 무조건 판다.
                buy=prices[i]; // 그자리에서 다시 산다.
            }
            else{
                buy= Math.min(buy, prices[i]);// 만일 이득을 볼수없다면 더 작은값이라는 뜻이니 더 작은값으로 업데이트
            }
        }return have;
    }
}
