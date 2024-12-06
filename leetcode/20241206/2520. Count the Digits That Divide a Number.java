/*
start: 11:30
end: 11:47
시간복잡도: O(log n) - 숫자의 자릿수만큼 반복
공간복잡도: O(1) - 추가 공간 상수만 사용
풀이: 각 자릿수를 추출하여 원본 숫자의 약수인지 확인
1. 일의 자리부터 각 자릿수를 하나씩 추출
2. 추출한 자릿수로 원본 숫자가 나누어 떨어지는지 확인
3. 나누어 떨어지는 자릿수의 개수를 카운트
*/
class Solution {
   public int countDigits(int num) {
       // 한 자리 수인 경우 바로 1 반환
       if(num <= 9) return 1;
       
       int count = 0;
       int temp = num;
       
       // 각 자릿수 확인
       while(temp > 0) {
           int digit = temp % 10;
           // 0이 아니고 나누어 떨어지는 경우 카운트
           if(digit != 0 && num % digit == 0) {
               count++;
           }
           temp /= 10;
       }
       
       return count;
   }
}
