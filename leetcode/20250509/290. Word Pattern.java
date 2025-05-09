/*
start:13:46
end:14:02
시간복잡도:O(N)
공간복잡도:O(N)
풀이:    Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
이렇게 매핑하는 방식도 좋다!~
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
