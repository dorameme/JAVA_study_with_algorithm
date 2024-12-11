/*
start: 17:01  
end: 17:15  
시간복잡도: O(n) - 문자열 `a`와 `b`의 길이를 맞추고, 자리 수를 하나씩 계산하는 반복문이 `a.length()` 또는 `b.length()`의 길이에 비례함.  
공간복잡도: O(n) - 결과 문자열 `answer`의 길이가 입력 문자열의 최대 길이에 비례하고, 추가로 `O(1)`의 상수를 사용하는 변수들이 있음.  

풀이:  
꼭 문자열로 풀어야한다. .. 길이가 매우길어서 어차피 정수로는 처리못함.
1. 입력된 두 문자열 `a`와 `b` 중 짧은 것을 `a`로 하여 연산의 순서를 일관되게 유지한다.  
2. 짧은 문자열 `a`의 길이를 긴 문자열 `b`와 동일하게 맞추기 위해 앞쪽에 '0'을 추가한다.  
3. 두 문자열의 각 자리를 오른쪽에서 왼쪽으로 반복하며 이진수 덧셈을 수행한다.  
   - 자리별 합은 `(num1 + num2 + carry) % 2`로 계산해 `answer`에 추가하고,  
   - 올림수(carry)는 `(num1 + num2 + carry) / 2`로 계산한다.  
4. 반복이 끝난 뒤에도 `carry`가 남아있으면, 이를 `answer`에 계속 추가한다.  
5. 최종적으로 계산된 `answer` 문자열을 반환한다.  
*/

class Solution {
    public String addBinary(String a, String b) {
        if(a.length()>b.length())
            return addBinary(b,a);
        //긴게 뒤로
        while(a.length()!=b.length()){
            a= "0" +a;
        }
        String answer = "";
        int carry=0;
        for(int i=a.length()-1;i>=0;i--){
            int num1 = b.charAt(i)-'0';
            int num2 = a.charAt(i)-'0';
            answer = (num1+num2+carry)%2 + answer;
            carry = (num1+num2+carry)/2 ;
        }
        while(carry!=0){
            answer =carry%2 +answer;
            carry/=2;
        }
        return answer;
    }
}

//근데 캐리처리를 한번에 하고 stringBuffer쓰는게 더 빠르다 답안은 아래첨부 
