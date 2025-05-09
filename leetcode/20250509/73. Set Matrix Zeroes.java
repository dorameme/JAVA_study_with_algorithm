/*
start:12:04
end:12:13
시간복잡도:O(NM)
공간복잡도:O(1)
풀이:첫열과 첫행을 마커로 사용한다! 그러면 따로 O(1)이상의 공간을 할당하지않고 해결할 수 있다.
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < n; i++){
          if(matrix[i][0]==0)firstRow = true ;
        }
        for (int i = 0; i < m; i++){
            if(matrix[0][i]==0)firstCol= true ;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(firstRow);
        if (firstRow) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }

        if (firstCol) {
            for (int i = 0; i < m; i++)
                matrix[0][i] = 0;
        }
    }
}
