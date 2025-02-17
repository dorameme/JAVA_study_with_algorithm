/*
start:12:01
end:12:48
시간복잡도:O(N*N)
공간복잡도:O(N*N)
풀이: 깜짝놀랐다 ;; 내가 푼거에 비해 너무 쉬운풀이가 있어서 .. dp로 풀면 빠르게 풀수있다. 코드를 첨부해두겠다.
*/
class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {// 만일 i번째 원소가
            for (int j = 0; j < k; j++) {
                answer = Math.max(answer,  dp[nums[i]%k][j]= dp[j][nums[i]%k]+1); // dp[x][y]는 x로 시작해서 y로 끝나는 애 .. 
            }
        }
        return answer;
    }
}

class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        boolean[][] check = new boolean[k][k];// 0번째랑 1번째 인덱스가 번갈아서 나옴.
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {// 만일 i번째 원소가
            int cur = nums[i] % k;// 현재 값
            for (int j = 0; j < k; j++) {
                if (check[j][cur] == false) {// 지금 cur이 나올 타이밍
                    check[j][cur] = true;
                    dp[j][cur]++;
                }if(check[cur][j] == true) {// cur가 나올 타이밍
                    check[cur][j] = false;
                    dp[cur][j]++;
                }
                if(cur==j){dp[cur][j]--;}//둘이 같으면.... 플러스가 두번씩 되니까;
                answer = Math.max(Math.max(answer, dp[cur][j]), dp[j][cur]);
            }
        }
        return answer;
    }
}
