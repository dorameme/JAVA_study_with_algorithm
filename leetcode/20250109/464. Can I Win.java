/*
start:10:30
end:11:25
시간복잡도: O(2^n * n) 
공간복잡도: O(2^n)
풀이: 나는 카드의 사용여부랑 남은 total을 따로 dp로 돌렸는데 둘이 관련된 정보이니까 각 카드를 썼나? 를 기준으로 dp를 돌렸어야했다.
아래는 수정코드
*/
class Solution {

    //  주의할점 지금 남은total에 대해 어떤 카드값들이 사용되었는지가 동시에 기록되어야한다.
    // 따라서 카드사용내역이 dp로 저장되어야한다. (남은 total은 어차피 유도속성)
    HashMap<Integer, Boolean> dp = new HashMap<>();
    int max;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        max = maxChoosableInteger;
        return solve(0,desiredTotal);
        
    }

    public boolean solve(int used, int total) {
        
        if (dp.containsKey(used)) {
            return dp.get(used);
        }
        if (total <= 0) {
            return true;
        }
        boolean now = false;////하나라도 이기면 이김
        for (int i = 1; i <= max; i++) {
            int cur = 1 << (i-1);
            if((used & cur) == 0) {//써본적없넹
                if(total<=i){dp.put(used,true);return true;}
                now = now || !solve( used | cur, total - i);//이길수 있는 경로가  하나라도 있면..
            }
        }
        dp.put(used, now);
        return now;
    }
}
