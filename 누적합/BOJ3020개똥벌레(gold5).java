/*
start: 11:37  
end: 12:37  

시간복잡도: O(N + H)  
- N개의 장애물을 입력받고 → O(N)  
- 높이 H에 대해 누적합을 계산하고 → O(H)  
- 최종적으로 각 높이에 대해 충돌 계산 → O(H)

공간복잡도: O(H + N)  
- 누적합 배열(dpD, dpU): O(H)  
- 입력 배열(down, up): O(N)  
풀이:  
1. 짝수 번째 입력은 석순, 홀수 번째 입력은 종유석으로 구분하여 각각의 등장 횟수를 기록한다.  
2. 석순은 바닥부터 올라오므로 실제 높이 기준으로 기록하고,  
   종유석은 천장에서 내려오므로 계산의 편의를 위해 H + 1 - 높이로 변형하여 기록한다.  
3. 누적합 배열 dpD (석순), dpU (종유석)를 만들어 각 높이에서 부딪히는 장애물 개수를 효율적으로 계산한다.  
4. 1부터 H까지 모든 높이에 대해 석순 + 종유석 부딪힘의 총합을 구해 최소값과 등장 횟수를 계산한다.


나는 이분탐색으로 안풀고 더 어렵게 풀었다 ㅠㅠㅠ
이분탐색으로 풀면 훨씬쉽다. 아래 두가지에대한 코드 넣겠음

*/
//누적합 풀이
public class Main {

    static int N, H;
    static int[] down, up, dpU, dpD;
    static

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, H;
    static int[] down, up,dpU,dpD;
    static HashMap<Integer, Integer> downDP = new HashMap<>();
    static HashMap<Integer, Integer> upDP = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        down = new int[N];
        up = new int[N];

        dpD= new int[H+2];
        dpU=new int[H+2];
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                down[i] = Integer.parseInt(br.readLine());
                downDP.merge(down[i], 1, Integer::sum);
            } else {
                up[i] = Integer.parseInt(br.readLine());
                upDP.merge(H+1-up[i], 1, Integer::sum);
            }
        }
        for(int i=H;i>=1;i--){
            dpD[i]=dpD[i+1]+ downDP.getOrDefault(i,0);
        }
        for(int i=1;i<=H;i++){
            dpU[i]=dpU[i-1] + upDP.getOrDefault(i,0);
        }
        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <= H; i++) {
            int total = 0;
            total += dpD[i];
            total += dpU[i];
            map.merge(total,1,Integer::sum);
            ans= Math.min(ans,total);
        }
        System.out.println(ans+" "+map.get(ans));
    }
}

//이분탐색

public class Main {

    static int N, H;
    static int[] down; // 석순
    static int[] up;   // 종유석

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 장애물의 총 개수
        H = Integer.parseInt(st.nextToken()); // 동굴의 높이

        down = new int[N / 2]; // 짝수 번째 입력: 석순
        up = new int[N / 2];   // 홀수 번째 입력: 종유석

        // 입력 분리
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) down[i / 2] = height; // 석순
            else up[i / 2] = height;              // 종유석
        }

        // 이분 탐색을 위한 정렬
        Arrays.sort(down);
        Arrays.sort(up);

        int minObstacles = Integer.MAX_VALUE; // 최소 부딪히는 장애물 수
        int count = 0;                        // 최소 부딪힘이 발생한 높이의 개수

        // 각 높이(1 ~ H)에 대해 계산
        for (int height = 1; height <= H; height++) {
            // 석순: 높이가 height 이상인 것의 개수
            int downCount = down.length - lowerBound(down, height);
            // 종유석: 높이가 (H - height + 1) 이상인 것의 개수
            int upCount = up.length - lowerBound(up, H - height + 1);

            int total = downCount + upCount;

            if (total < minObstacles) {
                minObstacles = total;
                count = 1;
            } else if (total == minObstacles) {
                count++;
            }
        }

        System.out.println(minObstacles + " " + count);
    }

    /**
     * 배열 arr에서 target 이상의 첫 번째 인덱스를 찾는다.
     * 즉, arr[i] >= target인 최소 i를 반환 (없으면 arr.length 반환)
     */
    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
