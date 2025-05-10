/*
start:22:00
end:22:22
시간복잡도: O(N)
공간복잡도: O(N)
풀이: 슬라이딩 윈도우 방식으로, 인덱스 차이가 k 이하인 중복 요소가 존재하는지를 확인한다.
Set을 이용해 최대 k개의 최근 요소만 유지하며, 중복이 있는지 확인한다.
Set에 이미 존재하는 값이 새로 들어올 경우 중복이 발생한 것이므로 true를 반환하고,
그 외에는 Set에 값을 추가하며 윈도우 범위를 유지하기 위해 k 초과의 오래된 값을 제거한다.
이 방식은 입력 배열을 한 번 순회하므로 시간복잡도는 O(N), Set의 최대 크기가 k이므로 공간복잡도도 O(N)이다.
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.getOrDefault(nums[i], 0) > 0) {
                return true;
            }
            m.merge(nums[i], 1, Integer::sum);
            if (i >= k)
                m.merge(nums[i - k], -1, Integer::sum);
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 이미 존재하면 조건 만족
            if (window.contains(nums[i])) {
                return true;
            }

            // 현재 원소 추가
            window.add(nums[i]);

            // 윈도우 크기 유지
            if (i >= k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}
