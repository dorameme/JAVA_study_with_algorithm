공부한 날짜 2024-05-23

1. min, max 로 풀기
    point:일단 한 인덱스에서 양옆을 기준으로 min(max왼쪽높이, max오른쪽높이)가 현 인덱스에서 물이 채워질 크기.
    예상 시간복잡도는 O(n)

class Solution {
    public int trap(int[] H) {
        int size = H.length;
        int[] leftH = new int[H.length];
        int[] rightH = new int[H.length];
        leftH[0] = H[0];
        rightH[size-1] = H[size-1];
        for(int i=1;i<size;i++){
            leftH[i] = Math.max(leftH[i-1], H[i]);
            rightH[size-1-i] = Math.max(rightH[size-i],H[size-1-i]);
        }
        int answer =0;
        for(int i=0;i<size;i++){
            answer += Math.min(leftH[i],rightH[i])-H[i];
        }
        return answer;
    }
}