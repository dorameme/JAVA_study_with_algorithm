/*
start:11:44
end:12:01
시간복잡도:O(N)
공간복잡도:O(1)
풀이: 홀/짝만 나오는경우 , 홀/짝이 번갈아서 나오는 경우로 나누어서 풀이하였다.
*/
class Solution {
    public int maximumLength(int[] nums) {
        // 짝짝 혹은 홀홀 인경우
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int oddToEven = 0;
        int evenToOdd = 0;
        boolean flagOddToEven = true;// if true is time to get odd
        boolean flagEvenToOdd = true;// if true is time to get even
        // 짝홀 혹은 홀짝 인경우
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {// even
                if (flagOddToEven == false) {// time to get even
                    flagOddToEven = true;
                    oddToEven++;
                }
                if (flagEvenToOdd == true) {
                    flagEvenToOdd = false;
                    evenToOdd++;
                }
            } else {// odd
                if (flagOddToEven == true) {// time to get odd
                    flagOddToEven = false;
                    oddToEven++;
                }
                if (flagEvenToOdd == false) {
                    flagEvenToOdd = true;
                    evenToOdd++;
                }
            }
        }
        int answer = Math.max(Math.max(odd, even), Math.max(oddToEven, evenToOdd));
        return answer;
    }
}
///개선된 코드
class Solution {
    public int maximumLength(int[] nums) {
        int odd = 0, even = 0, alternate = 1, maxAlternate = 1;
        
        // 첫 번째 원소의 홀/짝 여부 확인
        boolean isPrevOdd = (nums[0] % 2 != 0);
        if (isPrevOdd) odd++;
        else even++;

        // 배열 순회
        for (int i = 1; i < nums.length; i++) {
            boolean isOdd = (nums[i] % 2 != 0);

            // 짝수 또는 홀수 개수 카운트
            if (isOdd) odd++;
            else even++;

            // 번갈아 나오는 경우 카운트
            if (isOdd != isPrevOdd) {
                alternate++;
                maxAlternate = Math.max(maxAlternate, alternate);
            } else {
                alternate = 1; // 연속된 같은 값이 나오면 초기화
            }
            isPrevOdd = isOdd;
        }

        return Math.max(Math.max(odd, even), maxAlternate);
    }
}
