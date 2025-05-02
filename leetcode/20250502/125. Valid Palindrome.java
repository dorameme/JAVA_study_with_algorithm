/*
start:14:47
end:14:55
시간복잡도:O(N)
공간복잡도:O(1)
풀이:Character.toLowerCase(char ch)는 문자가 알파벳인 경우에만 소문자로 변환하고,
숫자나 특수문자는 그대로 반환한다.
즉, 숫자에 대해 안전하게 사용할 수 있다.
*/
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r= s.length()-1;
        while(l<r){
           if(!Character.isLetterOrDigit(s.charAt(l))){l++;continue;}
           if(!Character.isLetterOrDigit(s.charAt(r))){r--;continue;}
           if(Character.toLowerCase(s.charAt(l++))!= Character.toLowerCase(s.charAt(r--))){return false;}
        }return true;
    }
}
