/*
 * start:12:38
 * end:12:58
 * 시간복잡도:O(NlgN)
 * 공간복잡도:O(N)
 * 풀이: 단순히 소수를 구하는 문제인데 문제 범위가 2N이라는것에 주의해서 배열을 할당하자!
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] prime = new int[123457*2];
    public static void main(String[] args) throws IOException {
        for (int i = 2; i <= 123456*2; i++) {
            int isPrime = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = 0;
                    break;
                }
            }
            prime[i] = prime[i - 1] + isPrime;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while (num != 0) {
            System.out.println(prime[num * 2] - prime[num]);
            num = Integer.parseInt(br.readLine());
        }
    }
}
