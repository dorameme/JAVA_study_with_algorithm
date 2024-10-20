/*start:13:15
 end:13:40
 시간복잡도: O(N)
 공간복잡도:O(N)
 풀이: 단순한 그리디 문제라 정렬하고 풀어주면 된다. 경우의 수는 전체포함, 반만포함 , 불포함 이 세개로 나누어서 풀어주면 된다. 
더 쉬운풀이가 있길래 밑에 첨부한다.
나는 리스트로 바꾸어야 정렬이 가능할 줄 알았는데 그냥 배열을 Arrays.sort로 정렬가능하다는 것!
그리고 시작이아닌 끝으로 정렬하면 더 쉽게풀이가 가능하다 ㅠㅠ
*/

import java.util.Arrays;
import java.util.List;


class Solution {

    public int solution(int[][] routes) {
        int answer = 1;
        List<int[]> arr = Arrays.asList(routes);
        arr.sort((a, b) -> Integer.compare(a[0], b[0]));
        int end = arr.get(0)[1];
        for(int i=0;i<arr.size();i++){
            if (arr.get(i)[0] > end) {//포함되지 않음
                answer++;
                end = arr.get(i)[1];
            }
            else {//포함됨
                if (arr.get(i)[1] <= end) {
                    end = arr.get(i)[1];
                }
            }
        }
        return answer;
    }
}



import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {//만일 시작이 이전 끝보다 크면 .. 하나더 필요함..
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }
}
