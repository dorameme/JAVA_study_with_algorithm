/*
start:14:40
end:5:14
시간복잡도:O(N*M)
공간복잡도:O(N*M)
풀이: 대표적인 LCS문제인데도 나는 엄청 어렵게 풀었다.
따라서 정석풀이 + 내풀이를첨부한다.
DP 테이블을 구성하면서,
두 문자가 같으면 dp[i][j] = dp[i-1][j-1] + 1
다르면 dp[i][j] = max(dp[i-1][j], dp[i][j-1])
이후, dp[N][M]을 바탕으로 역추적을 통해 어떤 문자가 공통 수열에 들어가는지를 알아내고, 이를 문자열로 구성한다. 역추적은 dp[i][j]가 어디서 왔는지를 비교하며 수행된다.
이 방법은 시간/공간복잡도가 O(N*M)으로 효율적이며, 구현도 비교적 직관적이다.
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[][] dp;
    static String A, B;
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        A = bf.readLine();
        B = bf.readLine();
        dp = new int[A.length()+1][B.length()+1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if(A.charAt(i-1)== B.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        int cnt= dp[A.length()][B.length()];
        int x= A.length();
        int y= B.length();
        while(cnt>0 ||x+1==0 || y+1==0){//역추적
            if(dp[x][y]== dp[x-1][y]) x--;
            else if(dp[x][y]==dp[x][y-1])y--;
            else{
                x--;
                y--;
                sb.append(A.charAt(x));
                cnt--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int[][] dp;
    static String A, B;
    static String answer="";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        A = bf.readLine();
        B = bf.readLine();
        dp = new int[A.length()][B.length()];
       for(int i=0;i<A.length();i++)
        Arrays.fill(dp[i],-1);
        solve(0,0,new StringBuilder());
        System.out.println(answer);
    }

    static void solve(int a, int b, StringBuilder ans) {
       if(a>=A.length() || b>=B.length() ||(dp[a][b]!=-1 && dp[a][b]>=ans.length()))return;
        dp[a][b] = ans.length();
        if (A.charAt(a) == B.charAt(b)) {
          solve(a + 1, b + 1, ans.append(A.charAt(a)));
            if(ans!=null && answer.length() < ans.length()){
                answer= ans.toString();
            }
          ans.deleteCharAt(ans.length()-1);
          return;
        }
        solve(a + 1, b, ans);
        solve(a, b + 1, ans);

    }
}
