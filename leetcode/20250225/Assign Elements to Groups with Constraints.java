/*
start:12:33
end:12:50
시간복잡도:O(NlgN)
공간복잡도:O(N)
풀이:이게 시간복잡도는 똑같아도 배열을 써서 푸는게 훨씬 빠르다! 
아무래도 둘다 접근시간이 1이라도 해도..
첫 번째 코드는 HashMap을 사용하여 조회를 수행. HashMap은 평균적으로 O(1)이지만, 해시 충돌이 발생할 경우 성능이 저하될 수 있다.
두 번째 코드는 배열을 사용하여 조회를 수행. 배열의 조회는 항상 O(1)이며, 메모리 접근이 더 빠르다.
*/
class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int glen = groups.length;
        int elen = elements.length;
        HashMap<Integer, Integer> dp = new HashMap<>();
        HashMap<Integer, Integer> eMap = new HashMap<>();
        for (int i = elen - 1; i >= 0; i--) {
            eMap.put(elements[i], i);
        }

        int[] answer = new int[glen];
        for (int i = 0; i < glen; i++) {
            int tmp = Integer.MAX_VALUE;
            int cur = groups[i];
            if (dp.containsKey(cur)) {
                answer[i] = dp.get(cur);
                continue;
            }
            answer[i] = -1;
            for (int j = 1; j * j <= cur; j++) {
                if (cur % j == 0 && eMap.getOrDefault(j, -1) != -1) {
                    tmp = Math.min(tmp, eMap.getOrDefault(j, -1));
                }
                if (cur % (cur / j) == 0 && eMap.getOrDefault(cur / j, -1) != -1) {
                    tmp = Math.min(tmp, eMap.getOrDefault(cur / j, -1));
                }
            }
            answer[i] = tmp == Integer.MAX_VALUE ? -1 : tmp;
            dp.put(cur,answer[i]);
        }
        return answer;
    }
}
