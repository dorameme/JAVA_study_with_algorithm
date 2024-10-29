/*
 * start:12:38
 * end:12:49
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: using bigInteger to solve dp problem.
 * */


import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        BigInteger[] fibo = new BigInteger[10001];
        fibo[0] =new BigInteger("0");
        fibo[1] = new BigInteger("1");
        Scanner sc = new Scanner(System.in);
        for (int i = 2; i <= 10000;i++) {
            fibo[i] = fibo[i - 1].add ( fibo[i - 2]);
        }
        System.out.println(fibo[sc.nextInt()]);
    }
}

