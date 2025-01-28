/*
start:16:03
end:16:36
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 밑에 주석에 풀이를 써놨다.
return result.toArray(new int[result.size()][]); -> 이 함수 꽤나 쓸만함.
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        
        // 먼저 newInterval보다 끝나는 구간들을 result에 추가
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // newInterval과 겹치는 구간을 병합
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // 병합된 newInterval 추가
        result.add(newInterval);
        
        // 나머지 구간들 추가
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        // 결과를 2D 배열로 변환해서 반환
        return result.toArray(new int[result.size()][]);
    }
}
