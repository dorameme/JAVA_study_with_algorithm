공부한 날짜 2024-06-11

1. min, max 로 풀기
Point:가벼운 dp로 풀어낼 수 있었다.
근데 더 나은풀이가있다. -> 저점과 현재값과이 차이를 계산하는 방식!(저점의 price만 기록하면 된다!) 
내껀 두번의 반복문인데 이방법으로는 dp 없이 한번만 반복해서 풀어낼 수 있다.
//풀이 1
class Solution {

    public int maxProfit(int[] prices) {
        int[] dpMax=new int[prices.length];
        int[] dpMin=new int[prices.length];
        int answer=0;

        dpMin[0]=prices[0];
        dpMax[prices.length-1]=prices[prices.length-1];
       
        for(int i=1;i<prices.length;i++){
            dpMax[prices.length-1-i]= Math.max(dpMax[prices.length-1-i],prices[prices.length-1-i]);
            dpMin[i]= Math.min(dpMin[i-1],prices[i]);
        }
        
        for(int i=0;i<prices.length;i++) {
            if(dpMax[i]-dpMin[i]>answer)answer=dpMax[i]-dpMin[i];
        }
            return answer;
    }
}
//풀이 2
class Solution {

    public int maxProfit(int[] prices) {
        int answer=0;
        int minPrice=prices[0];
        for(int p: prices){
            minPrice= Math.min(minPrice, p);
            answer = Math.max(p-minPrice,answer);
        }
        return answer;
    }
}
