/*
start:16:20
end:17:17
시간복잡도:O(log(min(a, b)))
공간복잡도:O(N)
풀이:유클리드 호제법쓰는문제였는데, 두 String 을 비교할때 그냥 서로 위치를 바꾸어 더해서 나온 String 값이 같으면 된다.<-이걸몰라서 길이를 맞추느라 애먹었다 ㅜ.ㅜ
*/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int idx1=0,idx2=0;
        int l1= str1.length();
        int l2= str2.length();
        StringBuilder newS1 = new StringBuilder();
        StringBuilder newS2 = new StringBuilder();
        int gcd=findGcd(l1,l2);
        if((str1+str2).equals(str2+str1))
        if((newS1.toString()).equals(newS2.toString()))return str1.substring(0,gcd);
        return "";
    }
    public int findGcd(int a,int b){
        return b == 0 ? a: findGcd(b,a%b);   
    }
}
