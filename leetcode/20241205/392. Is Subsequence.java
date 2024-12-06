/*
start: 14:13
end: 14:38
시간복잡도: O(max(n,m)) - n,m은 각각 문자열 s,t의 길이
공간복잡도: O(1)
풀이: two pointer를 이용해서 문자열 s가 t의 부분수열인지 체크한다.
1. s가 비어있으면 부분수열이므로 true
2. t가 비어있는데 s가 남아있으면 false 
3. 두 포인터가 각 문자열 끝에 도달할 때까지:
  - 현재 문자가 같으면 두 포인터 모두 증가
  - 다르면 t의 포인터만 증가
4. s의 모든 문자를 찾았으면(pointS == s.length()) true, 아니면 false
*/
class Solution {
   public boolean isSubsequence(String s, String t) {
       // 초기 조건 체크
       if(s.length() == 0) return true;
       if(t.length() == 0) return false;
       
       int pointS = 0;
       int pointT = 0;
       
       // 두 문자열을 순회하며 검사
       while(pointS < s.length() && pointT < t.length()) {
           if(s.charAt(pointS) == t.charAt(pointT)) {
               pointS++;
               pointT++;
           } else {
               pointT++;
           }
       }
       
       return pointS == s.length();
   }
}
