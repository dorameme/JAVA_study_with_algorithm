/*
start:13:46
end:14:02
시간복잡도:O(N)
공간복잡도:O(N)
풀이:    Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
이렇게 매핑하는 방식도 좋다!~
그리고 문자열 비교는 항상 equals를 쓰자! 왜냐면... 
만약 tokens[i]가 split(" ")로 파싱된 문자열이라면,
이는 상수 풀에 있는 리터럴 문자열이 아닐 수 있다. 
그 결과 tokens[i]와 str[pattern.charAt(i) - 'a']는 서로 다른 객체가 될 수있다...
equals()를 사용하는 것이 안전하고, 두 문자열의 내용을 비교하는 방식이기 때문에 확실히 작동하니까
복잡하게 생각하지말고 그냥 equals써라


*/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = new String[26];
        String[] tokens = s.split(" ");
        if(tokens.length != pattern.length())return false;
        Set<String> set= new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (str[pattern.charAt(i) - 'a'] == null){
                if(set.contains(tokens[i]))return false;
                set.add(tokens[i]);
                str[pattern.charAt(i) - 'a'] = tokens[i];
            }
            else if (!str[pattern.charAt(i) - 'a'].equals(tokens[i])){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false;
            } else {
                if (wordToChar.containsKey(word)) return false;
                charToWord.put(c, word);
                wordToChar.put(word, c);
            }
        }
        return true;
    }
}
