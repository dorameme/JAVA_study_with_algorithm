
/*
 * start:12:00
 * end:12:14
 * 시간복잡도:O(lgN)
 * 공간복잡도:O(N)
 * 풀이: The problem requires finding the minimal possible value
 that allows dividing the array into M or fewer groups while keeping the maximum sum of any group as small as possible.
 * */
import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        long max = 0;
        long sum = 0;
        
        // 한번의 순회로 max와 sum을 구함
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        
        System.out.println(binarySearch(max, sum));
    }

    public static long binarySearch(long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;  // 오버플로우 방지
            
            // 현재 그룹의 합과 그룹 수를 추적
            long currentSum = 0;
            int groupCount = 1;
            
            // 그룹 나누기
            for (int num : arr) {
                if (currentSum + num > mid) {
                    groupCount++;
                    currentSum = num;
                } else {
                    currentSum += num;
                }
            }
            
            // 그룹 수에 따라 범위 조정
            if (groupCount <= M) {//그룹수 더 적어도 되겠는데? -> right값을 작게
                right = mid - 1;
            } else {
                left = mid + 1;//그룹수 부족해! 
            }
        }
        return left;
    }
}
