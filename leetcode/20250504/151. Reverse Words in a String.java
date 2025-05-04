/*
start:16:19
end:16:24
시간복잡도:O(N)
공간복잡도:O(1)
풀이:
StringTokenizer → 구시대적인 방식, 요즘은 split() 선호.
split()은 더 직관적이고, 강력하며, 현대적인 방식이다.
StringTokenizer는 유연하지 않고, 공식적으로도 새로운 코드에서 권장되지 않는다.

insert(0, ...) → 성능 비효율 → 대신 append() + 역방향 반복.
대부분의 경우 더 깔끔하고 간결하게 코드를 작성할 수 있다.

StringTokenizer함수중에 hasMoreTokens 이름을 헷갈렸다. 제대로 외워주자!
그리고 뒤에붙일땐 append, 앞에붙일땐 insert(0,~)를 써주자!


*/
//개선된 코드
public String reverseWords(String s) {
    StringBuilder ans = new StringBuilder();
    String[] words = s.trim().split(" ");
    for (int i = words.length - 1; i >= 0; i--) {
        if (words[i].isBlank()) continue; // 공백 필터링
        ans.append(words[i] + " ");
    }
    return ans.toString().trim();
}



import java.util.StringTokenizer;// <-추가하는이유? 릿코인데;?

class Solution {
    public String reverseWords(String s) {
        StringTokenizer stk = new StringTokenizer(s, " ");
        StringBuilder ans = new StringBuilder();
        while(stk.hasMoreTokens()) {
            ans.insert(0,stk.nextToken()+ " ");
        }
        return ans.toString().trim();
    }
}
