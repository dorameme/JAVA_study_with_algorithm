/*
start: 11:03
end: 11:19
시간복잡도: O(sqrt(n)) - n의 제곱근까지 소인수를 검사
공간복잡도: O(1) - 추가 공간 상수만 사용
풀이: 숫자에서 2,3,5를 제외한 소인수가 있는지 확인
1. 음수나 0은 ugly number가 아님
2. 주어진 수에서 2,3,5의 소인수를 모두 제거
3. 남은 수가 다른 소인수를 가지고 있는지 검사:
  - 2,3,5를 제외한 소인수가 있으면 false
  - 없으면 true

  그냥 2,3,5 전부 빼주고 1만 남으면 정답임.. ㅠㅠ 그게더 개선된 코드
*/  
  class Solution {
    public boolean isUgly(int n) {
        if(n<=0)return false;
        n=excludePrime235(n);
        for (int i = 2; i*i<= n; i++) {
            int div= excludePrime235(i);
            if(n % div == 0 ){
                return false;
            }
        }
        return true;
    }
    public int excludePrime235(int n){
        while(n%2==0){n/=2;}
        while(n%3==0){n/=3;}
        while(n%5==0){n/=5;}
        return n;
    }
}
//개선된 코드
public boolean isUgly(int n) {
    if(n <= 0) return false;//it has to be positive
    
    for(int factor : new int[] {2, 3, 5}) {
        while(n % factor == 0) {
            n /= factor;
        }
    }
    
    return n == 1; // 1이면 2,3,5외의 값으로는 안이루어져있다는 뜻이므로 정답!!!
}
