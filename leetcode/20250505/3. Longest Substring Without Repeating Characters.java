/*
시간복잡도:14:30
공간복잡도:14:44
풀이:
HashMap.merge는 가독성이 떨어지고, 로직이 복잡해질 수 있다.
→ 단순한 put과 get으로 충분하다.
num > 1 체크 및 merge 연산보다, 중복 문자의 마지막 위치를 저장하는 방식이 더 효율적이다.
중복 문자를 발견했을 때, 왼쪽 포인터를 바로 점프할 수 있다.
*/
//개선된풀이
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            }
            map.put(c, r);
            answer = Math.max(answer, r - l + 1);
        }

        return answer;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int l = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            int num = m.merge(s.charAt(r), 1, Integer::sum);
            if (num > 1) {
                while (s.charAt(l)!=s.charAt(r))
                {
                    m.merge(s.charAt(l++),-1,Integer::sum);
                }
                m.merge(s.charAt(l++),-1,Integer::sum);
            }
            answer = Math.max(answer, r - l +1);
        }
        return answer;
    }
}
