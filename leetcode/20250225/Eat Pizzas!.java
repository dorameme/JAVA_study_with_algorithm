/*
start: 11:50
end: 12:20
시간복잡도: O(N log N) - 배열 정렬에 따른 복잡도
공간복잡도: O(1) - 상수 크기의 추가 공간 사용
풀이: 
1. 피자 배열을 정렬한다.
2. 피자를 선택하는 규칙에 따라, 홀수 날과 짝수 날의 최대 무게 피자를 선택한다.
   - 홀수 날: 뒤에서부터 `oddDays` 개수만큼 선택
   - 짝수 날: 뒤에서 두 번째부터 `evenDays * 2` 개수 중, 홀수 인덱스 피자 선택
3. 최종적으로 선택한 피자 무게의 합을 반환한다.
*/
class Solution {
    int cnt=0;
    int[] vis = new int[200001];
    
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        long answer=0;
        int evenDays=pizzas.length/4/2;
        int oddDays=(pizzas.length/4+1)/2;
        for(int i=1;i<=oddDays;i++){
            answer += pizzas[pizzas.length-i];
        }
        for(int i=1;i<=evenDays*2;i+=2){
            answer += pizzas[pizzas.length-oddDays-i-1];
        }
        
        return answer;
    }
}



/*
개선사항:
- 불필요한 전역 변수 제거
- 배열 길이를 반복적으로 계산하지 않고 변수로 저장
- 변수명을 더 직관적으로 수정
*/

import java.util.Arrays;

class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        long totalWeight = 0;
        int n = pizzas.length;
        int evenDays = n / 4 / 2;
        int oddDays = (n / 4 + 1) / 2;
        
        // 홀수 날 선택
        for (int i = 0; i < oddDays; i++) {
            totalWeight += pizzas[n - 1 - i];
        }
        
        // 짝수 날 선택
        for (int i = 0; i < evenDays; i++) {
            totalWeight += pizzas[n - oddDays - (2 * i) - 1];
        }
        
        return totalWeight;
    }
}
