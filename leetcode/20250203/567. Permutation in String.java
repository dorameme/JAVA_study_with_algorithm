/*
start:19:00
end:19:33
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 굳이 콜렉션쓸필요가 없다! 배열로 두고 그대로 풀이가능하다.Arrays.equals(arr1, arr2)로 비교해주자! 아래 더 나은코드 첨부!
*/
class Solution {
     public boolean checkInclusion(String s1, String s2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> helper = new HashMap<>();
        int cnt = s1.length();
        if(s2.length()<s1.length())return false;
        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i)-0,0);
            helper.put(s2.charAt(i)-0,0);
        }
        for (int i = 0; i < s1.length(); i++) {
            map.merge(s1.charAt(i)-0, 1, Integer::sum);
            helper.merge(s2.charAt(i)-0,1,Integer::sum);
        }
        System.out.println(map);
        for(int i=s1.length();i<s2.length();i++){
          if(map.equals(helper))return true;
           helper.merge(s2.charAt(i)-0,1,Integer::sum);
           helper.merge(s2.charAt(i-s1.length())-0,-1,Integer::sum);
        }
        return map.equals(helper);
    }
}


import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] target = new int[26]; // s1의 문자 개수를 저장할 배열
        int[] window = new int[26]; // 현재 윈도우 내 문자 개수를 저장할 배열

        for (char c : s1.toCharArray()) target[c - 'a']++;
        for (int i = 0; i < s1.length(); i++) window[s2.charAt(i) - 'a']++;

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(target, window)) return true;
            window[s2.charAt(i) - 'a']++; // 새로 들어온 문자 추가
            window[s2.charAt(i - s1.length()) - 'a']--; // 윈도우에서 벗어난 문자 제거
        }
        
        return Arrays.equals(target, window);
    }
}
