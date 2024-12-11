/*
start: 19:13  
end: 19:40  
시간복잡도: O(n + m) - n은 배열 `num`의 길이, m은 정수 `k`의 자리수.  
공간복잡도: O(n + m) - 결과 리스트의 크기가 배열 `num`의 길이와 정수 `k`의 자릿수에 비례.  

풀이:  
1. 배열 `num`의 마지막 자리부터 순회하며 정수 `k`와 올림수(carry)를 더해 자리값을 계산.  
2. 정수 `k`가 남아있는 경우, 남은 자리수를 계산.  
3. 마지막으로 올림수가 남아있다면 추가.  
4. 결과 리스트를 뒤집어 반환.
*/
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer = new ArrayList<>();
        int carry = 0;

        for (int i = num.length - 1; i >= 0 || k > 0; i--) {
            int digit = (i >= 0 ? num[i] : 0) + (k % 10) + carry;
            answer.add(digit % 10);
            carry = digit / 10;
            k /= 10;
        }

        if (carry > 0) {
            answer.add(carry);
        }

        Collections.reverse(answer);
        return answer;
    }
}

//내코드 
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer= new ArrayList<>();
        int carry=0;
        for(int i=num.length-1;i>=0;i--){
            int tmp= k%10 + num[i]+ carry;
            carry = tmp/10;
            tmp= tmp%10;
            k/=10;
            answer.addFirst(tmp);
        }
        while(k!=0){
            int tmp= k%10 + carry;
            carry= tmp/10;
            tmp= tmp%10;
            k/=10;
            answer.addFirst(tmp);
        }
        if(carry !=0 )
        answer.addFirst(carry);
        return answer;
    }
}
