/*
start: 20:01
end: 20:33
시간복잡도: O(N)
- 각 인덱스마다 한 번씩만 계산 (메모이제이션)
- 각 인덱스에서 최대 3또는 4번의 반복문 실행 (상수)
공간복잡도: O(N)
- dp배열 사용 (문자열 길이만큼)
- 재귀 호출 스택 공간 (최대 문자열 길이만큼)

풀이: -> 중요한건 dp[i] 의 기준은 i로 시작하는 모든 경우의 수이므로 여기서 이어지는애들 모두 다 구해서 합해줘야해!!!
1. DP(메모이제이션) + 재귀를 이용한 풀이
2. dp[i]: i번째 인덱스에서 시작하는 가능한 모든 조합의 수
3. 각 위치에서:
  - 현재 숫자(7,9는 4개, 나머지는 3개 문자)의 최대 반복 횟수 확인
  - 연속된 같은 숫자만큼 반복하면서 각각의 경우에 대해 재귀 호출
  - 모든 경우의 수를 더하고 MOD 연산
4. 기저 조건: 문자열 끝에 도달하면 1 반환(하나의 유효한 조합 완성)
5. 오버플로우 방지를 위해 중간 계산에 long 사용
*/

class Solution {
    int len;
    int[] dp = new int[100001];/// 시작점 기준..

    public int countTexts(String pressedKeys) {
        len = pressedKeys.length();
        Arrays.fill(dp, -1);
        return countTexts(pressedKeys, 0);
    }

    public int countTexts(String s, int idx) {
        if (idx == len)
            return 1;// 끝에 도착

        if (dp[idx] != -1)
            return dp[idx];

        int num = s.charAt(idx);
        int rep = num == 7+'0' || num==  9+'0' ? 4 : 3;
        long ret = 0;
        for (int i = idx;i<len && i < idx + rep; i++) {
            if (s.charAt(i) != num)
                break;
            ret += countTexts(s, i + 1);// 다음인덱스로 넘어가기 전에..
            ret %= 1000000007;
        }
        return dp[idx] = (int)ret;
    }
}
