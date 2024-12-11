/*
start:19:41
end:19:49
시간복잡도: O(n) (최악의 경우)
공간복잡도: O(1) (대부분의 경우), O(n) (모든 자리가 9인 경우)
풀이: 새로 공간을 만들지 않고 주어진 배열을 재홯용해서 푸는방식이 최고다.. 나는 맨밑에 내코드 첨부
*/
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // 모든 자리가 9인 경우 (예: 999 -> 1000)
        int[] newDigits = new int[digits.length + 1];// -> 천재냐?..
        newDigits[0] = 1;
        return newDigits;
    }
}

//내 코드
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> arr =new ArrayList<>();
        int carry=1;
        for(int i=digits.length-1; i>=0; i--){
            int tmp= digits[i] + carry;
            arr.add(tmp%10);
            carry= tmp/10;
        }
        if(carry!=0)arr.add(carry);
        Collections.reverse(arr);
        int[] answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]= arr.get(i);
        } 
        return answer;
    }
};
