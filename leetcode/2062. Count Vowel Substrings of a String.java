/*
start: 14:47
end: 15:04
시간복잡도: O(n²) - n은 문자열의 길이
공간복잡도: O(1) - HashSet과 HashMap이 고정된 크기(최대 5)를 가짐
풀이: 슬라이딩 윈도우와 HashMap을 이용해 모음으로만 이루어진 부분 문자열 개수를 세는 방식
1. 모음을 저장하는 HashSet 초기화
2. 문자열을 순회하며:
  - 현재 문자가 모음이면 HashMap에 추가
  - 자음이면 HashMap 초기화
3. HashMap 크기가 5(모든 모음 포함)이상이면:
  - 현재 위치에서 뒤로 가며 모음으로만 이루어진 부분문자열 카운트
  - 자음을 만나면 중단
*/
class Solution {
   HashMap<Character, Integer> mainMap = new HashMap<>();
   Set<Character> vowels = new HashSet<>();
   
   public int countVowelSubstrings(String word) {
       // 모음 집합 초기화
       vowels.addAll(Set.of('a', 'e', 'i', 'o', 'u'));
       
       int answer = 0;
       
       for (int i = 0; i < word.length(); i++) {
           char currentChar = word.charAt(i);
           
           // 현재 문자 처리
           if (vowels.contains(currentChar)) {
               mainMap.merge(currentChar, 1, Integer::sum);
           } else {
               mainMap.clear();
               continue;
           }
           
           // 모든 모음을 포함하는 경우 처리
           if (mainMap.size() >= 5) {
               HashMap<Character, Integer> tempMap = new HashMap<>();
               for (int j = i; j >= 0; j--) {
                   if (vowels.contains(word.charAt(j))) {
                       tempMap.merge(word.charAt(j), 1, Integer::sum);
                       if (tempMap.size() >= 5) {
                           answer++;
                       }
                   } else {
                       break;
                   }
               }
           }
       }
       
       return answer;
   }
}
