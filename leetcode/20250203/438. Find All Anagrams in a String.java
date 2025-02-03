/*
start:19:33
end:19:44
시간복잡도: O(N)
공간복잡도: O(1)
풀이: 슬라이딩 윈도우 기법을 사용하여 문자열 s의 모든 애너그램이 p에서 등장하는 위치를 찾는 문제이다.  
     s의 길이만큼 문자 빈도를 저장하는 배열 compare[]을 만들고, p의 처음 s.length() 길이만큼 문자 빈도를 저장하는 배열 map[]을 만든다.  
     이후 슬라이딩 윈도우를 이동시키면서 compare[]과 map[]을 비교하여 동일한 경우 해당 시작 인덱스를 정답 리스트에 추가한다.  
     슬라이딩 윈도우는 한 문자씩 오른쪽으로 이동하며 새로 들어온 문자를 추가하고, 윈도우에서 벗어난 문자를 제거하는 방식으로 동작한다.  
     배열 비교는 Arrays.equals()를 사용하여 O(1) 시간 복잡도로 수행된다.  
     전체 시간 복잡도는 O(N), 공간 복잡도는 O(1)이다.
*/
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String p, String s) {
        if (p.length() < s.length()) return new ArrayList<>();

        int[] target = new int[26]; // s의 문자 개수 저장
        int[] window = new int[26]; // 현재 윈도우 내 문자 개수 저장
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;
            target[p.charAt(i) - 'a']++;
        }

        for (int i = s.length(); i < p.length(); i++) {
            if (Arrays.equals(target, window)) result.add(i - s.length());
            window[p.charAt(i) - 'a']++; // 새로 들어온 문자 추가
            window[p.charAt(i - s.length()) - 'a']--; // 윈도우에서 벗어난 문자 제거
        }

        if (Arrays.equals(target, window)) result.add(p.length() - s.length());
        return result;
    }
}
