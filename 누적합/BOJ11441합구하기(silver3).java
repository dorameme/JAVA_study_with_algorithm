/*
start:16:00
end:16:22
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 간단 dp 누적합 문제인데...
Long 말고 primitive long을 써서 배열을 만드는게 더편하다.
어차피 primitive로 하면 0으로 채워져서 초기화과정이 필요없으므로 편하고, 더 빠르다. (메모리도 덜 먹음!)
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        Long[] dp = new Long[N+1];
        Long[] nums = Arrays.stream(br.readLine().split(" ")).map(Long::valueOf).toArray(Long[]::new);
        dp[0]=0L;
        for(int i=1;i<=N;i++){
            dp[i]= dp[i-1] + (nums[i-1]);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           bw.append(dp[s[1]]-dp[s[0]]+nums[s[0]-1] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}




//고친코드

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        for(int i=1;i<=N;i++){
            dp[i]= dp[i-1] + (nums[i-1]);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           bw.append(dp[s[1]]-dp[s[0]]+nums[s[0]-1] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
