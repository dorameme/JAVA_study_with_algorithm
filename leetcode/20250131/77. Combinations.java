/*
start:14:07
end:14:29
시간복잡도: O(C(n, k))  
공간복잡도: O(k * C(n, k))  // 결과를 저장하는 공간이 k 크기의 리스트를 C(n, k)개 저장해야 하므로 k * C(n, k).
풀이:
기본적인것을 짚고넘어갈 수 있었는데 일단 
1. static 변수로 두면 여러 테스트 케이스에서 이전 결과가 누적될 수 있다. 따라서 인스턴스 변수로 변경하여 각 테스트 케이스마다 독립적인 상태를 유지하게 풀어야한다.
2. vis 배열을 쓸 필요가 없다. 왜냐하면 idx를 통해 중복을 방지할 수 있기 때문. idx는 현재 선택한 수보다 큰 수만 선택하도록 제한하여 중복 조합을 방지.
*/
class Solution {
    int N, K; // N: 전체 숫자 범위, K: 선택할 숫자의 개수
    List<List<Integer>> answer = new ArrayList<>(); // 결과를 저장할 리스트

    public List<List<Integer>> combine(int n, int k) {
        N = n; // 전체 숫자 범위 설정
        K = k; // 선택할 숫자의 개수 설정
        dfs(0, 1, new ArrayList<Integer>()); // DFS 시작
        return answer; // 결과 반환
    }

    public void dfs(int now, int idx, List<Integer> comb) {
        if (now == K) { // 현재 선택한 숫자의 개수가 K개라면
            List<Integer> helper = new ArrayList<>(); // 현재 조합을 복사하여 저장
            for (int i = 0; i < K; i++) {
                helper.add(comb.get(i));
            }
            answer.add(helper); // 결과 리스트에 추가
            return;
        }
        for (int i = idx; i <= N; i++) { // idx부터 N까지 반복
            comb.add(i); // 현재 숫자를 조합에 추가
            dfs(now + 1, i + 1, comb); // 재귀 호출: now + 1, idx + 1
            comb.removeLast(); // 백트래킹: 마지막에 추가한 숫자 제거
        }
    }
}
