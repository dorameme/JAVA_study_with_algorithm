/*
start:17:10
end:17:20
시간복잡도:O(N)
공간복잡도:O(N)
풀이:단순한 누적합문제 항상주의해야할건 계속 바뀌는 tmp 변수를 선언해야한다는 점! answer를 tmp처럼 쓰면 안돼!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long ans = 0;
        int cnt = 1;
        for (int i = 0; i < X; i++) {
            ans += arr[i];
        }
        long tmp=ans;
        for (int i = X; i < N; i++) {
            tmp += arr[i]-arr[i-X];
            if(tmp>ans){
                cnt=1;
                ans= tmp;
            }
            else if(tmp==ans){cnt++;}
        }
        if(ans==0){
            System.out.println("SAD");
            return;
        }
        System.out.println(ans);
        System.out.println(cnt);
    }
}


//조금더 클린하게


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());
        
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        
        // 초기 슬라이딩 윈도우 설정
        long maxSum = 0;
        for (int i = 0; i < X; i++) {
            maxSum += arr[i];
        }
        
        long currentSum = maxSum;
        int count = 1;

        // 슬라이딩 윈도우 탐색
        for (int i = X; i < N; i++) {
            currentSum += arr[i] - arr[i - X];  // 윈도우 업데이트

            if (currentSum > maxSum) {
                maxSum = currentSum;
                count = 1;  // 새로운 최대 합을 찾았을 때 카운트 초기화
            } else if (currentSum == maxSum) {
                count++;  // 최대 합이 같은 경우 카운트 증가
            }
        }

        // 결과 출력
        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
