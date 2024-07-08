/*
start:14:00
end:14:30
시간복잡도:O(n*n)
공간복잡도:O(n*n)
풀이: 단순구현문제! 규칙을 찾아서 삼각형을 그려야한다. 삼각형을 만들기위해 포문안에 포문 3개를 넣었다.
*/
class Solution {
    public int[] solution(int n) {
            int[] answer = new int[n*(n+1)/2];
            int[][] helper = new int[n * 3][n * 3];
            int x = 0;
            int y = 0;
            int cnt = 1;
            for (int i = n; i > 0; i -=3) {
            
                if(x<0 || y<0)break;
                for (int j = i-1; j >= 0; j--) {
                    helper[x++][y] = cnt++;
                }
                x--; y++;
                if(x<0 || y<0)break;
                for (int j = i - 2; j >= 0; j--) {
                    helper[x][y++]=cnt++;
                }
                x--;y--;y--;
                if(x<0 || y<0)break;
                for (int j = i - 3; j >= 0; j--) {
                    helper[x--][y--]=cnt++;
                }
                x++;x++;y++;
            }
            cnt=0;
                for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if(helper[i][j]!=0){
                    answer[cnt++]=helper[i][j];
                }}
            }
            return answer;

    }
}
