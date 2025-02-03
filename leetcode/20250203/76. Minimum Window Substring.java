/*
start:19:44
end:19:47
시간복잡도: O(N)
공간복잡도: O(1)
풀이: 꽤나 복잡했다 ㅠㅠ 포인터를 두고 만일 구간내에 need보다 많은 알파벳이 나오면 제거하는 방식으로 풀이
*/
class Solution {
    
     public String minWindow(String s, String t) {
        int[] target = new int[126];
        int[] window = new int[126];
        int[] spare = new int[126];

        if (s.length() < t.length()) {
            return "";
        }
        for (int i = 0; i < t.length();i++) {
            target[t.charAt(i) - 'A']++;
        }
        
        String answer="";
        int before=0;
        for (int i = 0; i < s.length(); i++) {
            if (Arrays.equals(window, target)) {//만일 구성요소 다모음
                if (answer.equals("") || answer.length() > i - before)
                    answer = s.substring(before, i);
            }
            if(target[s.charAt(i)-'A']>0){
                if(window[s.charAt(i)-'A']<target[s.charAt(i)-'A'])
                window[s.charAt(i)-'A']++;
                else
                spare[s.charAt(i)-'A']++;
            }
            while(before<i){
                if(target[s.charAt(before) - 'A'] == 0) {//필요없엉..길이조절
                    before++;
                }
                else if( spare[s.charAt(before)-'A']>0){
                    spare[s.charAt(before)-'A']--;
                    before++;
                }
                else break;
            }
        } 
        if (Arrays.equals(window, target)) {//만일 구성요소 다모음
                // System.out.println("!");
                if (answer.equals("") || answer.length() > s.length() - before)
                    answer = s.substring(before, s.length());
        }
        return answer;
    }
}
