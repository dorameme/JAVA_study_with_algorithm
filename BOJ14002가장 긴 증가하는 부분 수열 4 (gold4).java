/*
start:11:30 
end:~중간에 점심~13:44
시간복잡도: O(N^2)  이중 for문에서 LIS의 길이를 구하므로 최악의 경우 N * N
공간복잡도: O(N^2)  각 dp[i]에 대해 수열을 저장한 ArrayList를 사용해 복사하면서 메모리 증가

풀이:
  - 가장 긴 증가하는 부분 수열(LIS) 문제.
  - dp[i]는 i번째 수를 마지막 원소로 갖는 LIS의 길이를 의미.
  - 각 위치 i마다 이전 값들과 비교해서 arr[j] < arr[i] 조건을 만족하면,
    dp[j] + 1 값이 dp[i]보다 크면 갱신.
  - LIS 자체를 복원하기 위해, map[i]에 i번째 수열까지의 LIS 수열을 ArrayList로 저장.
  - dp 갱신과 함께 수열도 복사 + 추가하여 map에 저장함.
  - 최종적으로 가장 긴 수열을 ans에 저장해 출력함.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] input = bf.readLine().split(" ");
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        dp[1] = 1;
        ArrayList<Integer> start = new ArrayList<>();
        start.add(arr[1]);
        map.put(1, start);
        ArrayList<Integer> ans = start;
        for (int i = 2; i <= n; i++) {
            start = new ArrayList<>();
            start.add(arr[i]);
            map.put(i, start);
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {// 지금꺼가 더 크면
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        ArrayList<Integer> nums = new ArrayList<>(map.get(j));
                        nums.add(arr[i]);
                        map.put(i, nums);
                    }
                }
            }
            if (ans.size() < map.get(i).size()) {
                ans = map.get(i);
            }
        }
        System.out.println(ans.size());
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }
}
