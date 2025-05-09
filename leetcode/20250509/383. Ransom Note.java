/*
start:12:40
end:12:55
시간복잡도:O(n_m)
공간복잡도:O(n+m)
풀아: HashMap<Character, Integer>의 평균 시간 복잡도는 O(1) 이 맞지만, 배열보다는 오버헤드가  더 크다 따라서 
배열로 정의하여 풀어주는게 더 빠르다~~!!!
*/

//개선된 풀이
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; // 알파벳 소문자만 있으므로 배열 사용 (더 빠르고 공간도 작음)

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            m.merge(magazine.charAt(i),1,Integer::sum);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int cnt = m.getOrDefault(ransomNote.charAt(i),0);
            if (cnt > 0) {
                m.put(ransomNote.charAt(i), cnt - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
