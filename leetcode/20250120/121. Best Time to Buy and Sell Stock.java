/*
start:9:14
end:9:33
시간복잡도:
공간복잡도:
풀이:첫번째 풀이인데 이렇게 풀 필요없었다. 아래에 개선된 풀이 첨부  
*/
class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[] min= new int[len];
        int[] max= new int[len];
        min[0]=prices[0];
        max[len-1]=prices[len-1];

        for(int i=1;i<len;i++){
            min[i]= Math.min(min[i-1],prices[i]);
            max[len-1-i]= Math.max(max[len-i],prices[len-i-1]);
        }
        int answer=0;
        for(int i=0;i<len;i++){
            answer=Math.max(answer, max[i]-min[i]);
        }
        return answer;
    }
}

/*
start: 9:53
end: 9:58
시간복잡도: O(n)
    - 배열을 한 번 순회하면서 최소값과 최대 이익을 계산하므로 O(n)이다.

공간복잡도: O(1)
    - 추가적인 배열을 사용하지 않고 변수 `min`, `max`, `answer`만 사용하므로 공간복잡도는 O(1)이다.

풀이:
1. 초기화:
   - 첫 번째 날의 주가를 `min`과 `max`로 설정한다.
   - 최대 이익을 저장할 변수 `answer`를 0으로 초기화한다.
2. 반복문:
   - 배열을 순회하면서 각 날의 주가와 현재까지의 최소값 `min`을 비교해 최소값을 업데이트한다.
   - 현재 주가와 `min`의 차이를 계산해 최대 이익을 갱신한다.
3. 최종적으로 계산된 최대 이익 `answer`를 반환한다.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0]; // 첫 번째 날의 주가를 최소값으로 설정
        int answer = 0;      // 최대 이익 초기화

        // 배열 순회하면서 최소값과 최대 이익 갱신
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i]; // 최소값 업데이트
            }
            answer = Math.max(answer, prices[i] - min); // 최대 이익 갱신
        }

        return answer; // 최대 이익 반환
    }
}
