/*
start:16:00
end:16:30
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 간단한 구현문제인데, 밑의 주의할점을 안지켜서 몇번 틀렸다 ㅜㅜ
*/
import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] keypad, String password) {
        int answer=0;
        List<int[]> map = new ArrayList<>();
        for(int i=0;i<=9;i++){
            map.add(new int[]{0,0});
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map.set(keypad[i*3+j],new int[]{i,j}); //주의할점 i에는 3을 곱해줘야함!
            }
        }
        for(int i=0;i<password.length()-1;i++){
            int[] dir = map.get(password.charAt(i) - '0');
            int[] dir2= map.get(password.charAt(i+1)-'0');
            int[] helper = len(dir,dir2);
            answer+=Math.max(helper[0],helper[1]);
        }
        return answer;
    }


    public static int[] len(int[] x, int[] y) {
        return new int[]{abs(x[0] - y[0]) , abs(x[1] - y[1])};
    }//거리


    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
