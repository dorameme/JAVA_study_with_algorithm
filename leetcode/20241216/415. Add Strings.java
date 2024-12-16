/*
start:16:10
end:16:28
시간복잡도:O(N) -> 문자열 길이
공간복잡도:O(N) -> 문자열 길이
풀이:나는 두번쨰 코드로 풀었고 개선방법은 첫번째 코드처럼 푸는것이다.
포인터로 풀어낼때 더 간결하게 풀수 있었다.
*/

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder answer= new StringBuilder();
        int p1=num1.charAt(p1);
        int p2=num2.length();
        int carry=0;
        
        while(p1>=0  || p2>=0|| carry != 0){
            int num=0;
            if(p1>=0){
                num+= num1.charAt(p1--)-'0';
            }
            if(p2>=0){
                num+= num2.charAt(p2--)-'0';
            }
            if(carry!=0){
                num+= carry;
            }
            answer.append(num%10);
            carry=num/10;
        }
        return answer.reverse().toString();
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length()>num2.length())
            return addStrings(num2,num1);

        while(num1.length()!= num2.length()){
            num1= "0" + num1;
        }
        StringBuilder answer= new StringBuilder();
        int carry=0;
        for(int i=num1.length()-1; i>=0;i--) {
            int newNum = num1.charAt(i)-'0' + num2.charAt(i)-'0' + carry;
            answer.append(newNum % 10);
            carry = newNum / 10;
        }
        if(carry !=0 )
        answer.append(carry);
        return answer.reverse().toString();
    }
}
