/*
start: 12:51
end: 13:23

시간 복잡도: O(N + M) (N: 과목 수, M: 선수 과목 관계 수)
 - 선수 과목 관계를 저장하는 과정: O(M)
 - 큐를 이용한 위상 정렬 과정: O(N + M) (각 노드를 한 번씩 방문, 모든 간선을 한 번씩 처리)

공간 복잡도: O(N + M)
 - `before`와 `after` 배열을 사용하므로 O(N)
 - 각 과목이 최대 M개의 관계를 가질 수 있으므로 O(M)

풀이:
1. 선수 과목 정보를 저장하는 `before`(필요한 선수 과목 목록)과 `after`(해당 과목을 들으면 수강 가능해지는 과목 목록) 배열을 생성한다.
2. 선수 과목이 없는 과목들을 찾아 큐에 추가한다.
3. 큐에서 과목을 하나씩 꺼내면서, 이를 선수 과목으로 하는 과목들의 `before` 배열에서 제거한다.
4. `before` 배열이 비어 있는 과목을 다시 큐에 추가하며, 모두 수강할 수 있는지 확인한다.
*/

import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 선수 과목을 저장하는 리스트
        ArrayList<Integer>[] before = new ArrayList[numCourses];
        // 해당 과목을 이수하면 들을 수 있는 과목을 저장하는 리스트
        ArrayList<Integer>[] after = new ArrayList[numCourses];

        // 각 과목별 리스트 초기화
        for (int i = 0; i < numCourses; i++) {
            before[i] = new ArrayList<>();
            after[i] = new ArrayList<>();
        }

        // 선수 과목 정보를 저장
        for (int[] prerequisite : prerequisites) {
            before[prerequisite[0]].add(prerequisite[1]); // prerequisite[1]이 필요
            after[prerequisite[1]].add(prerequisite[0]);  // prerequisite[1]을 들으면 prerequisite[0]을 수강 가능
        }

        // 선수 과목이 없는 과목을 큐에 추가
        LinkedList<Integer> q = new LinkedList<>();
        int count = 0; // 이수한 과목 수
        
        for (int i = 0; i < numCourses; i++) {
            if (before[i].isEmpty()) { // 선수 과목이 없는 경우 즉시 수강 가능
                q.add(i);
                count++;
            }
        }

        // 위상 정렬 (BFS 방식)
        while (!q.isEmpty()) {
            int cur = q.removeFirst(); // 현재 수강 가능한 과목
            
            // 현재 과목을 선수 과목으로 하는 과목 리스트 처리
            for (int next : after[cur]) {
                before[next].remove(Integer.valueOf(cur)); // 선수 과목 제거
                
                // 더 이상 선수 과목이 없다면 큐에 추가
                if (before[next].isEmpty()) {
                    q.add(next);
                    count++;
                }
            }
        }

        // 모든 과목을 이수할 수 있으면 true 반환
        return count == numCourses;
    }
}
