/*
start: 14:30
end: 14:47
시간복잡도: O(n*m) - n은 s의 길이, m은 words 배열의 길이
공간복잡도: O(k) - k는 words 배열의 고유한 단어 수
풀이: HashMap을 이용해 이미 검사한 단어의 결과를 저장하고 재활용하는 방식
1. HashMap에 단어와 부분수열 여부를 저장해 중복 계산 방지
2. 각 단어마다:
 - 이미 검사한 단어면 저장된 결과 사용
 - 새로운 단어면 Two Pointer로 부분수열 검사
   * S: 원본 문자열 포인터
   * T: 타겟 단어 포인터
3. 검사 결과를 HashMap에 저장하고 부분수열이면 answer 증가
*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int answer=0;
        HashMap<String, Boolean> hs=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String target= words[i];
            if(hs.containsKey(target) ){
                if(hs.get(target)){
                    answer++;
                }
                continue;
            }
            int T=0;
            int S=0;
            while(S<s.length() && T<target.length()){
                if(s.charAt(S) == target.charAt(T)){
                    S++;
                    T++;
                }
                else S++;
            }
            if(T == target.length()){
                hs.put(target,true);
                answer++;
            }
            else{
                hs.put(target,false);
            }
        }
        return answer;
    }
}
//더 나은 버전
class Solution {
  public int numMatchingSubseq(String s, String[] words) {
      int answer = 0;
      HashMap<String, Boolean> memo = new HashMap<>();
      
      for(String word : words) {
          // 이미 검사한 단어인 경우
          if(memo.containsKey(word)) {
              if(memo.get(word)) answer++;
              continue;
          }
          
          // 새로운 단어 검사
          int mainPtr = 0;
          int wordPtr = 0;
          
          while(mainPtr < s.length() && wordPtr < word.length()) {
              if(s.charAt(mainPtr) == word.charAt(wordPtr)) {
                  mainPtr++;
                  wordPtr++;
              } else {
                  mainPtr++;
              }
          }
          
          // 결과 저장 및 카운트
          boolean isSubseq = wordPtr == word.length();
          memo.put(word, isSubseq);
          if(isSubseq) answer++;
      }
      
      return answer;
  }
}
