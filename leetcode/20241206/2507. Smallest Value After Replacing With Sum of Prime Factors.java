/*
start: 12:32
end: 12:41
시간복잡도: O(n * sqrt(n)) - n이 소수가 될 때까지 반복하며 각 단계에서 sqrt(n)까지 검사
공간복잡도: O(1) - 상수 공간만 사용
풀이: 주어진 수가 소수가 될 때까지 소인수분해하여 그 합을 구하는 과정 반복
1. 소수 판별 함수:
  - 2는 소수
  - 2부터 sqrt(n)까지 나누어 떨어지는지 확인
2. 메인 로직:
  - 소수가 아닐 때까지 반복:
    * 소인수분해하여 소인수들의 합을 구함
    * 이전 값과 같아지면 순환이므로 종료
*/
class Solution {
   public int smallestValue(int n) {
       while(!isPrime(n)) {
           int previousValue = n;
           int factorSum = 0;
           
           // 소인수분해!
           for(int i = 2; i * i <= n; i++) { // 이렇게 빼면 어차피 소인수들만 나온다... 애초에 작은애들부터 다 뺴주니까!!
               while(n % i == 0) {
                   factorSum += i;
                   n /= i;
               }
           }
           
           // 남은 수가 1이 아니면(소수면) 더해줌
           n = (n != 1) ? factorSum + n : factorSum;
           
           // 이전 값과 같으면 순환이므로 종료
           if(previousValue == n) return n; // -> 순환하는 경우가 있다는게 포인트
       }
       
       return n;
   }
   
   private boolean isPrime(int n) {
       if(n < 2) return false;//1도 따로 처리해줘야함
       if(n == 2) return true;
       
       for(int i = 2; i * i <= n; i++) {
           if(n % i == 0) return false;
       }
       return true;
   }
}

//나의 구린코드

class Solution {

    ArrayList<Integer> prime = new ArrayList<>();
    int tmp;
    public int smallestValue(int n) {
        while (!isPrime(n)) {///소수가 아닐때까지 반복.
            tmp=n;
            int add=0;
            System.out.println(n);
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    add+=i;
                    n/=i;
                    i--;
                }
            }
            if(n!=1)
            n+=add;
            else
            n= add;
            if(tmp==n)return n;
        }
        return n;
    }

    public boolean isPrime(int n) {
        if(n==1)return false;
        if(n==2)return true;
        boolean flag = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
               return false;
            }
        }
        return true;
    }
}
