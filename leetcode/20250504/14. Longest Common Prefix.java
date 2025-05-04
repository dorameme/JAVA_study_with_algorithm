/*
start: 16:03
end:16:13
시간복잡도:O(NM)
공간복잡도:O(M)
풀이: 중요한건 문제를 풀때 자꾸 스트링을 바꾸면 느리니 .. stringBuilder를 써주자는것!
추가 설명 – 왜 StringBuilder를 쓰는가?
Java의 String은 불변하기 때문에 + 연산을 할 때마다 새로운 문자열 객체를 생성한다.
반복적으로 문자열을 덧붙일 경우 StringBuilder는 하나의 내부 배열을 사용하여 append 하므로 성능이 훨씬 좋다.
특히 반복문 안에서 str += something을 계속 하면 성능 저하가 크다.

*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
            StringBuilder ans = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i ||strs[j-1].length()<=i || strs[j-1].charAt(i)!= strs[j].charAt(i)){
                    return ans.toString();
                }
            }ans.append(strs[0].charAt(i));
        }return  ans.toString();
    }
}
