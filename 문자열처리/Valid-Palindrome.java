공부한 날짜 2024-05-18

1. 문자열을 문자단위로 추출해서 풀기(Runtime 123ms)
    point: Character.isLetterOrDigit()이라는 함수를 알게되었다.
class Solution {
    public boolean isPalindrome(String s) {

        s = s.toUpperCase();
        String helper= "";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                helper += String.valueOf(s.charAt(i));
            }
        }
        for(int i=0;i<helper.length()/2;i++){
            if(helper.charAt(i) != helper.charAt(helper.length()-1-i))return false;
        }
        return true;
    }
}
2. 문자열 직접비교(Runtime 14ms)

    point: replaceAll()함수에 정규식을 넣어 변형시켰는데,
     정규식에서 ^ 는 제외라는 뜻이다. 따라서 a~z , 0~9 를 제외한 모든걸 없애는게 가능했다.
     reverse 함수는 StringBuilder에 있다. String 과 String Builder는 다르므로 서로 같은지 비교해주기위해
    String Builder-> String 으로 전환시켜줬다. 이 과정에서 toString(), String.valueOf()두가지 함수가 가능헀는데
    NullPointException이 발생하지않는( null그대로 반환해줌 ) String.valueOf()를 선택하였다.
class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase().replaceAll("[^a-z0-9]","");
        return s.equals(String.valueOf(new StringBuilder(s).reverse()));
    }
}