/*
start: 13:45  
end: 14:05  
시간복잡도: O(N^2)  
공간복잡도: O(N^2)  

풀이:  
- 카드게임처럼 두 배열 `left`, `right`가 주어진다.  
- 한 턴마다 아래 세 가지 중 하나를 선택할 수 있다:  
  1. 왼쪽 카드만 버린다: solve(l+1, r)  
  2. 양쪽 다 버린다: solve(l+1, r+1)  
  3. 오른쪽 카드의 값이 더 작을 경우, 오른쪽 카드 점수 얻고 오른쪽만 버린다: right[r] + solve(l, r+1)  

주의할 점! -> result(ret)을 따로 두는 이유:  
- 만약 중간에 `return`을 써버리거나 `ret` 없이 조건별로 바로 `dp[l][r] = ...` 처리를 하면  
  한쪽 경우만 반영되어 최적값이 누락되는 심각한 버그가 생긴다.  
- 따라서 `ret`으로 모든 경우의 수를 고려해서 최댓값을 구한 후, `dp[l][r]`에 단 한 번 저장해야 한다.
*/



class Main {

    static int[][] dp = new int[2001][2001];
    static int N;
    static int[] left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        left = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        right = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(0, 0));
    }

    public static int solve(int l, int r) {
        if(l==N || r==N)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        int ret=0;
        if(left[l]>right[r]) ret= right[r] + solve(l,r+1);
        ret = Math.max(ret,Math.max(solve(l+1,r), solve(l+1,r+1)));
        return dp[l][r] =ret;
    }
}
