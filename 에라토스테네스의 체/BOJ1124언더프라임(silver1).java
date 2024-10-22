/*
 * start:11:01
 * end:11:31
 * 시간복잡도:O(lgN)
 * 공간복잡도:O(lgN)
 * 풀이: Always be careful not to change the variables in the 'for' statement!
And since it may be a prime number itself so find all prime numbers up to 100000.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf)
            .collect(Collectors.toList());
        List<Integer> primes = new ArrayList<>();
      
        for (int i = 2; i <= 100000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        int answer = 0;
        for (int i = numbers.get(0); i <= numbers.get(1); i++) {
            int count = 0;
            int idx = 0;
            int tem = i;
            while (tem != 1) {
                if (tem % primes.get(idx) == 0) {
                    tem /= primes.get(idx);
                    count++;
                } else {
                    idx++;
                }
            }
            if (isPrime(count)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
