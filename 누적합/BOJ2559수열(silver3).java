/*
start:21:10
end:21:54
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 누적합을 구하는 문제였다. 유의할 점은 answer 외에 변수를 하나더 둬야 한다는 것.
더 클린한 코드는 아래 참고!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        int[] nums = new int[100000];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        int answer = 0;
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
            answer += nums[i];
        }
        int compare = answer;
        for (int i = K; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
            compare = compare-nums[i-K]+ nums[i];
            answer = Math.max(answer, compare);
        }
        System.out.println(answer);
    }
}



import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] nums = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray(); // -> 바로 배열로 만들어준다.
        
        int sum = Arrays.stream(nums, 0, K).sum();// -> nums를 스트림으로 sum값을 한번에 구해준다.
        int maxSum = sum;
        
        for (int i = K; i < N; i++) {
            sum = sum - nums[i-K] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        
        System.out.println(maxSum);
    }
}
