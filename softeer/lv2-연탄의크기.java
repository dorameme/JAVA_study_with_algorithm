/*
start: 14:35
end: 15:00

시간복잡도: O(N log M) (N: 입력 개수, M: 최댓값 100)
 - 각 숫자의 약수를 찾는 과정은 `O(log M)`, 이를 N번 반복 → O(N log M)

공간복잡도: O(101) ≈ O(1) (배열 `factorCount`만 사용)
 - 2차원 배열을 사용하지 않고 `factorCount[101]`만 사용하여 공간 최적화.

풀이:
1. `arr[i]`에 대해 모든 약수를 찾아, 해당 약수의 빈도를 `factorCount[j]++`로 저장.
2. `factorCount[j]` 중 최댓값을 찾아 출력.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] factorCount = new int[101]; // 각 약수의 빈도를 저장하는 배열

        // 입력 처리 및 약수 계산
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            for (int j = 1; j <= arr[i]; j++) { // 1부터 해당 숫자까지 탐색
                if (arr[i] % j == 0) { 
                    factorCount[j]++;
                }
            }
        }

        // 가장 많이 등장한 약수 찾기
        int maxCount = 1;
        for (int i = 2; i <= 100; i++) {
            maxCount = Math.max(maxCount, factorCount[i]);
        }

        System.out.println(maxCount);
    }
}
