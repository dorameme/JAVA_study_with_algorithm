/*
start: 15:21
end: 15:38
시간복잡도: O(rowIndex^2) 
공간복잡도: O(rowIndex^2) - dp 배열 사용
풀이: 파스칼의 삼각형을 dp로 구현
1. 파스칼의 삼각형 성질:
  - 각 행의 처음과 끝은 1
  - 나머지 값은 위 행의 인접한 두 수의 합
2. dp[n][r]: n번째 행의 r번째 값
3. 점화식: dp[n][r] = dp[n-1][r-1] + dp[n-1][r]

근데 훨씬 쉬운방식이 있음. 밑에 첨부하겠음!! 
누적으로 계산가능 ㅠ
*/
class Solution {
   public List<Integer> getRow(int rowIndex) {
       // 초기 조건 처리
       List<Integer> result = new ArrayList<>();
       if(rowIndex < 0) return result;
       
       // dp 배열 초기화
       Integer[][] dp = new Integer[rowIndex + 2][rowIndex + 2];
       
       // 첫 번째 값은 항상 1
       result.add(1);
       if(rowIndex == 0) return result;
       
       // dp 계산
       dp[0][0] = 1;
       for(int row = 1; row <= rowIndex + 1; row++) {
           // 각 행의 처음과 끝은 1
           dp[row][0] = dp[row][row-1] = 1;
           
           // 중간 값들 계산
           for(int col = 1; col < row - 1; col++) {
               dp[row][col] = dp[row-1][col-1] + dp[row-1][col];
               
               // 목표 행인 경우 결과에 추가
               if(row == rowIndex + 1) {
                   result.add(dp[row][col]);
               }
           }
       }
       
       // 마지막 값 추가
       result.add(1);
       return result;
   }
}


////더 쉬운풀이 

public class Solution {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1]; // key point! -> 덮어쓰기때문에 뒤에서부터 앞으로 와야함..
        
        return Arrays.asList(arr);
    }
}
