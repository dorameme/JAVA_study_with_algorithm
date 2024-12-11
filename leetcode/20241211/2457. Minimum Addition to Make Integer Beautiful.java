/*
start: 11:00  
end: 12:13  
시간복잡도: O(log(n)^2)  
- 숫자를 10으로 나누는 과정이 O(log(n)),  
- 자리수 합을 계산하는 과정이 각 반복마다 O(log(n))이므로, 전체는 O(log(n)^2)  
공간복잡도: O(1)  
- 상수 공간만 사용함.  

풀이:  
1. 주어진 숫자 `n`에서 시작하여, 자리수 합(sum)이 `target` 이하가 되도록 숫자를 증가시켜야 함.  
2. 숫자를 자리수 단위로 조정하면서 계산을 효율적으로 수행.  
   - 자리수 합이 target 이하가 될 때까지 숫자를 10으로 나누고 올림하여 조정.  
   - `base` 변수를 사용하여 자리수 이동을 추적.  
3. 조건을 만족하는 숫자가 발견되면, 변경된 숫자와 원래 숫자의 차이를 계산하여 반환.
*/
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long current = n;
        long base =1;
        for(int i=0;;i++){
            int sum=0;
            long cal=current;
            while(cal>0){
               sum+= cal%10;
                cal/=10;
            }
            if(sum<=target){
                return base*current - n;
            }
            else{
                current = current/10 +1;
                base*=10;
            }
        }
       
    }
  
}
