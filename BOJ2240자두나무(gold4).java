/*
start:13:48
end:14:39
시간복잡도: O(T × W)
공간복잡도: O(T × W)
풀이:
  - 자두가 떨어지는 시간과 위치(1 또는 2)를 입력받고, 각 시간마다 자두를 받을 수 있는 최대 개수를 DP로 계산한다.
  - 초기에는 1번 나무 아래에 있으므로, 첫 번째 자두가 1번에 떨어지면 받는 것으로 시작한다.-> 이런 초기값 설정에 주의하자.
  - 점화식:
    - dp[A][i][w] = max(dp[A][i-1][w] + 1, dp[B][i-1][w-1] + 1)
      → 현재 자두가 A 위치에 떨어질 때, A에 계속 있었거나 B에서 이동한 경우
    - dp[B][i][w] = dp[B][i-1][w]
      → 자두가 B에 떨어지지 않아서 못 받은 경우 유지
  - 모든 시간과 이동횟수를 순회하면서 최대 자두 개수를 갱신하고 출력
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int T = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int[][][] dp = new int[2][T+1][33];
        //0 ,1 에 떨어짐..
        int max = 1; //항상 초기값 설정에 주의하기
        if(Integer.parseInt(bf.readLine()) - 1 == 0){
            dp[0][0][0]=1;
            dp[0][0][1]=1;
        }
        else{
            dp[1][0][1]=1;
        }
        for (int i = 1; i <T; i++) {
            int A = Integer.parseInt(bf.readLine()) - 1;// 0 or 1 에 떨어짐
            int B = Math.abs(A - 1);
            for (int w = 0; w <= W && w <= i; w++) {
                if(w==0){//이동을 한적이 없어
                    dp[A][i][w]= dp[A][i-1][w]+1;
                    dp[B][i][w]= dp[B][i-1][w];
                    continue;
                }
                dp[A][i][w] =Math.max(dp[A][i][w], Math.max(dp[A][i - 1][w] + 1, dp[B][i - 1][w - 1] + 1));
                dp[B][i][w] = dp[B][i - 1][w];
                max= Math.max( Math.max(max, dp[A][i][w] ),dp[B][i][w]);
            }
        }
        System.out.println(max);
    }
}
