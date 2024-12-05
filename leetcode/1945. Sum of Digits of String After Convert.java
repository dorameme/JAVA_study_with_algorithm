/*
start: 18:59
end: 19:16
시간복잡도: O(n*k) - n은 문자열 길이, k는 변환 횟수 
공간복잡도: O(n) - 문자열 저장 공간
풀이: 문자를 숫자로 변환하고 k번 각 자리 숫자의 합을 구하는 과정 반복
1. 알파벳을 해당하는 숫자로 변환 (a=1, b=2, ...)
2. k번 반복하여 각 자리 숫자의 합을 구함:
  - 문자열의 각 자리를 숫자로 변환하여 합산
  - 합계를 다시 문자열로 변환
3. 최종 결과를 정수로 변환하여 반환
*/
class Solution {
   public int getLucky(String s, int k) {
       // 알파벳을 숫자로 변환
       StringBuilder converted = new StringBuilder();
       for(char c : s.toCharArray()) {
           converted.append(c - 'a' + 1);
       }
       
       String current = converted.toString();
       
       // k번 변환 반복
       for(int i = 0; i < k; i++) {
           int sum = 0;
           
           // 각 자리 숫자의 합 계산
           for(char digit : current.toCharArray()) {
               sum += digit - '0'; //이게 진짜 편하다,..내 망한코드는 아래첨부 
           }
           
           current = String.valueOf(sum);
       }
       
       return Integer.parseInt(current);
   }
}


///내 망한 코드 
class Solution {
    public int getLucky(String s, int k) {
        String helper = "";
        for(int i=0;i<s.length();i++){
            helper += "" +(s.charAt(i)-'a'+1);
        }
         String answer=helper;
        for(int i=0;i<k;i++){  
            String helper2=answer;
            int helper3=0;
            while(helper2.length()>0){
                helper3 += helper2.charAt(helper2.length()-1)-'0';
                helper2= helper2.substring(0,helper2.length()-1);  //-> 그냥 하나씩 더해주는데 이렇게 복잡하게 하다니 ㅠㅠ
            }
            answer="" + helper3;
        }
        return Integer.parseInt(answer);
    }
}
