/*
start: 10:48
end: 11:08
시간복잡도: O(N²) - 문자열의 길이만큼 순회하며, 매번 재귀 호출로 문자열을 계속 줄여나감
공간복잡도: O(N) - 재귀 호출 스택과 새로운 문자열을 저장하는 StringBuilder 사용
풀이: 스트링을 더하거나 뺄 때는 역시 StringBuilder가 빠르다. 
      각 인접한 숫자의 합의 마지막 자릿수를 새 문자열에 추가하며 재귀적으로 처리한다.
*/
class Solution {
    public boolean hasSameDigits(String s) {
        if (s.length() == 1) return true; // 길이가 1이면 종료
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) return true;
        
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            newS.append((s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10);
        }
        
        return hasSameDigits(newS.toString());
    }
}
