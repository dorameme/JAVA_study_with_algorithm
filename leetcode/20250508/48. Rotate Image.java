/*
start:14:02
end:14:38
시간복잡도:O(NM)
공간복잡도:O(1)
풀이:순서가 중요하다. 나는 좌우 대칭하고 '\' 대각선대칭으로 풀었어서 좀 지저분한 코드가 되었다
 '/' 대각선 대칭하고 좌우대칭하는게 훨씬 코드도 깔끔하고 쉽다.
*/

//better code
class Solution {
    public void rotate(int[][] matrix) {
        int x=0;
        int y=0;
        int len = matrix.length;
        for(int i=0;i<len;i++){
            for(int j=i; j<len  ;j++){
                int tmp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                 matrix[j][i]= tmp;
            }
        }
        for(int i=0;i<len;i++){
            
            for(int j=0;j<len/2;j++){
                int tmp =  matrix[i][j] ;
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-j-1]=  tmp;
            }
        }
    }
}


class Solution {
    public void rotate(int[][] matrix) {
        int x=0;
        int y=0;
        int len = matrix.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                int tmp =  matrix[i][j] ;
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-j-1]=  tmp;
            }
        }
       
         for(int i=0;i<len;i++){
            int cnt=len-1-i;
            for(int j=0; cnt>0 && i+cnt<len && j+cnt<len  ;j++){
                if(i+cnt<len ){
                int tmp= matrix[i][j];
                matrix[i][j] = matrix[i+cnt][j+cnt];
                matrix[cnt+i][cnt+j]= tmp;
                cnt--;
                }
            }
        }
    }
}

