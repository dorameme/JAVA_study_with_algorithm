공부한 날짜 2024-05-19
1. 팰린드롬을 발견하면 확장하는 풀이
    point: str.substring(x,y) ->인덱스 x 부터 인덱스 y-1 까지 데려오므로 y+1를 넣어주자
    String substring(int startIndex)
    String substring(int startIndex, int endIndex)
class Solution {
    int l=0 , r = 0;
    public void extendPalindromic(String s ,int j,int k){
        if(j>=0 && k<s.length() &&  s.charAt(j) == s.charAt(k)){
            if(r-l < k-j){
                System.out.println(s+" "+j+" "+k);
                l=j;
                r=k;
            }
            extendPalindromic(s,j-1,k+1);
        }
    }
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            extendPalindromic(s,i,i+1);
            extendPalindromic(s,i,i);
        }
        return s.substring(l , r+1);
    }
}