
/*
start:19:34
end:19:55
시간복잡도:O(N^2)->O(N)
공간복잡도:O(1)
풀이:내가푼풀이는 아래인데 이걸 더 쉽게푸는 방식이 있어서 가져왔다!
역시 항상 개선사항은 있다는것 유의! 
나는 역방향으로 풀었고 풀이는 정방향 그리디!
*/
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;         // 최소 점프 횟수
        int currentEnd = 0;    // 현재 점프 범위의 끝
        int farthest = 0;      // 현재 인덱스까지 볼 수 있는 가장 먼 도달 지점

        // 마지막 칸은 도달하면 끝이므로 마지막 인덱스 전까지만 순회
        for (int i = 0; i < nums.length - 1; i++) {
            // i번째 인덱스에서 도달 가능한 가장 먼 거리 계산
            farthest = Math.max(farthest, i + nums[i]);

            // 현재 인덱스가 현재 점프 범위의 끝에 도달하면
            if (i == currentEnd) {
                jumps++;                // 점프 횟수 증가
                currentEnd = farthest;  // 다음 점프 범위 설정
            }
        }

        return jumps;
    }
}

int target = len;       // 마지막 지점을 목표로 설정
while (target != 0) {   // 0에 도달할 때까지 반복
    for (int j = target - 1; j >= 0; j--) {
        if (nums[j] + j >= target) {
            // j에서 target까지 갈 수 있다면
            newTarget = j;
            if (newTarget == 0) return answer + 1;
        }
    }
    target = newTarget; // 타겟을 갱신 (더 이전으로)
    answer++;           // 점프 횟수 증가
}

