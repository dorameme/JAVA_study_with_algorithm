/*
 * start:9:17
 * end:10:00
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:음... 문제이해를 잘못했다. 그냥 증가하는부분찾는건줄알았는데 이어지는 증가하는 부분이었다.
 아래에 클린한 코드를 첨부해놨다. 변수명이 더 직관적이다.
 그리고 공간복잡도가 1이다. 따로 dp배열을 만들필요가 없는문제였다!!

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        arr[0] = Integer.parseInt(stk.nextToken());
        dp[0] = 1;
        dp2[0] = 1;

int answer=1;
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            if (arr[i - 1] >= arr[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            if(arr[i-1]<=arr[i]){
                dp2[i]= dp2[i-1]+1;
            }
            else{
                dp2[i]=1;
            }
            int helper= Math.max(dp[i],dp2[i]);
            answer= Math.max(helper,answer);
        }
        System.out.println(answer);
    }
}
//클린코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        // 배열 하나만 사용
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        // 증가/감소 길이를 각각 저장
        int increasingLen = 1;
        int decreasingLen = 1;
        int maxLen = 1;
        
        // 한 번의 순회로 두 가지 경우를 모두 체크
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i-1]) {
                increasingLen++;
            } else {
                increasingLen = 1;
            }
            
            if (arr[i] <= arr[i-1]) {
                decreasingLen++;
            } else {
                decreasingLen = 1;
            }
            
            maxLen = Math.max(maxLen, Math.max(increasingLen, decreasingLen));
        }
        
        System.out.println(maxLen);
    }
}
