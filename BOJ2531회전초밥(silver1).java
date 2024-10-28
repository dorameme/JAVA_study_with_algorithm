
/*
 * start:15:06
 * end:16:49
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: 애초에 음수를 다룰 필요가없다 ;; 너무 꼬아서 생각한듯
 Reduced Modulo Calculations: Using [(i + k - 1) % N] directly instead of idx improves clarity and efficiency.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main {

    static int N, d, k, c;
    static HashMap<Integer, Integer> dp = new HashMap<>();
    ;
    static int[] sushis = new int[300001];
    static int[] cnt = new int[300001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = str[0];
        d = str[1];
        k = str[2];
        c = str[3];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N - k; i < N; i++) {
            int nx = idx(i);
            int sushi = sushis[nx];
            dp.put(sushi, dp.getOrDefault(sushi, 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            int nx = idx(i);
            int sushi = sushis[nx];
            int removeSushi = sushis[idx(nx - k)];
            dp.put(sushi, dp.getOrDefault(sushi, 0) + 1);
            dp.put(removeSushi, dp.get(removeSushi) - 1);
            if (dp.get(removeSushi) == 0) {
                dp.remove(removeSushi);
            }
            if (dp.containsKey(c)) {
                answer = Math.max(dp.size(), answer);
            } else {
                answer = Math.max(dp.size() + 1, answer);
            }
        }
        System.out.println(answer);
    }
    static public int idx(int x) {
        if (x < 0) {
            return idx(x + N);
        } else {
            return x;
        }
    }
}



//clean ver
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N, d, k, c;
    static int[] sushis;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        d = input[1];
        k = input[2];
        c = input[3];
        
        sushis = new int[N];
        for (int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }
        
        count = new int[d + 1]; // 각 초밥 종류의 개수를 저장하는 배열
        int distinctCount = 0; // 현재 윈도우 안에 있는 서로 다른 초밥 종류 수
        int maxCount = 0; // 최대로 먹을 수 있는 초밥 종류 수
        
        // 첫 번째 윈도우 초기화 (크기 k)
        for (int i = 0; i < k; i++) {
            if (count[sushis[i]] == 0) distinctCount++;
            count[sushis[i]]++;
        }
        
        // 쿠폰 초밥 포함 여부 확인 후 최대값 갱신
        maxCount = count[c] == 0 ? distinctCount + 1 : distinctCount;
        
        // 윈도우를 한 칸씩 이동하면서 계산
        for (int i = 1; i < N; i++) {
            // 윈도우에서 빠져나가는 초밥
            int removeIdx = sushis[(i - 1) % N];
            count[removeIdx]--;
            if (count[removeIdx] == 0) distinctCount--;
            
            // 윈도우에 새로 들어오는 초밥
            int addIdx = sushis[(i + k - 1) % N];
            if (count[addIdx] == 0) distinctCount++;
            count[addIdx]++;
            
            // 쿠폰 초밥 포함 여부 확인 후 최대값 갱신
            int currentMax = count[c] == 0 ? distinctCount + 1 : distinctCount;
            maxCount = Math.max(maxCount, currentMax);
        }
        
        System.out.println(maxCount);
    }
}

