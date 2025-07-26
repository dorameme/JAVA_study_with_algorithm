/*
start:10:12
end:10:58
시간복잡도:O(NM)
공간복잡도:O(M)
풀이:전형적인 DP문제이다.
근데 못풀어서 다른 풀이를 참고했다.
-> 동전을 하나씩 사용하면서, 해당 동전으로 만들 수 있는 모든 금액을 갱신하는 방식이다.
   i원을 만들 수 있는 경우의 수는 i-coin원을 만들 수 있는 경우의 수에 coin을 더하는 방식으로 누적된다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {


    static int ans;

    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] dp = new int[10001];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(bf.readLine()));
        }
        dp[0]=1;
        for(int coin:arr){
            for(int i=0;i<=k;i++){
                if(i>=coin)
                dp[i]+= dp[i-coin];
            }
        }

        System.out.println(dp[k]);
    }

}
