/*
start:19:55
end:20:21
시간복잡도:O(NlgN)
공간복잡도:O(1)
풀이: 처음엔 O(N^2)으로 풀었다가 풀이를 정렬해서 바꾸었다.
문제를 이해하는게 좀 어려웠는데 .. 총 인용된횟수A랑 A이상의 논문들이 A번 이상 인용된 수의 최댓값 A를 구하는문제..;; 문제자체가 이해가어려워 밑에 
예시첨부하겠다.

H-Index는 몇일까?
"h편 이상의 논문이 각각 최소 h번 이상 인용되었는가?"
h = 0 → 5편 이상이 0번 이상 인용 → O (항상 참)
h = 1 → 4편이 1번 이상 인용됨 → O
h = 2 → 4편이 2번 이상 인용됨 → O
h = 3 → 3편이 3번 이상 인용됨 → O
h = 4 → 2편이 4번 이상 → X
h = 5 → 2편이 5번 이상 → X

*/
class Solution {
    public int hIndex(int[] c) {
        int len = c.length;
        Arrays.sort(c);
        int answer=0;
        for(int i=0;i<len;i++){
            int num= Math.min(c[i], len-i);
            answer = Math.max(answer ,num);
        }
        return answer;
    }
}
