/*
 * start:11:32
 * end:11:48
 * 시간복잡도:O(K * √M)
  K: 생성되는 소수의 개수
  M: 확인하는 가장 큰 수
 * 공간복잡도:O(K)
 * 풀이:동적 프로그래밍과 백트래킹을 활용한 소수 생성 방식
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> [] primes= new ArrayList[9];
        for(int i=0;i<9;i++){primes[i]=new ArrayList<>();}
    // (List<Integer> currentPrimes = Arrays.asList(2, 3, 5, 7);) -> 이게더 편함..
      // List<Integer> currentPrimes = List.of(2, 3, 5, 7); -> 이건 불변
        primes[1].add(2); 
        primes[1].add(3);
        primes[1].add(5);
        primes[1].add(7);
        for(int i=1;i<=N;i++){
            for(int j=1;j<=9;j++){
                for(Integer prime:primes[i]){
                    Integer num = prime*10+j;
                    if(isPrime(num)){
                        primes[i+1].add(num);
                    }
                }
            }
        }
      primes[N].sort((a,b)-> a-b);
        for(Integer prime:primes[N]) {
            System.out.println(prime);
        }
    }
    public static boolean isPrime(Integer  num){
        if(num==2)return true;
        if(num==1)return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }return true;
    }
}
