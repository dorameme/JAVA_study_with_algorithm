/*
start: 19:21
end: 19:31
시간복잡도: O(logn) - n의 각 자리 제곱의 합을 구하는 과정
공간복잡도: O(logn) - HashSet에 저장되는 숫자의 수
풀이: 각 자리 숫자의 제곱합을 반복 계산하면서 순환되는 수를 HashSet으로 체크
1. 숫자를 문자열로 변환하여 각 자리 접근
2. HashSet을 사용하여 이전에 나온 수를 기록
3. 각 자리 숫자의 제곱합을 계산
4. 1이 나오면 true, 순환이 발견되면 false
*/
class Solution {
   public boolean isHappy(int n) {
       Set<String> seenNumbers = new HashSet<>();
       String current = String.valueOf(n);
       
       while (!seenNumbers.contains(current)) {
           seenNumbers.add(current);
           
           // 각 자리 숫자의 제곱합 계산
           long squareSum = 0;
           for (char digit : current.toCharArray()) {
               int num = digit - '0';
               squareSum += num * num;
           }
           
           // 결과가 1이면 행복수
           current = String.valueOf(squareSum);
           if (current.equals("1")) {
               return true;
           }
       }
       
       // 순환이 발견되면 행복수가 아님
       return false;
   }
}
