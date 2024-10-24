
/*
 * start:12:01
 * end:12:30
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:
 if (prime.contains(num - prime.get(i))) {  // O(N) 
    // ...
}

// 정상작동 코드의 핵심 부분
if (isPrime[num-prime.get(i)]==1) {  // O(1) 
    // ...
}

 Given:
N = 1,000,000 (maximum number)
Up to 100,000 test cases
Time limit: 0.5 seconds

TLE Version:
CopyO(N²) * number of test cases
= 1,000,000² * 100,000
= 10^17 (Too slow!)

Working Version:
CopyO(N) * number of test cases
= 1,000,000 * 100,000
= 10^11 (Achievable within 0.5 seconds)
Key Improvements

Replaced ArrayList.contains() with direct array access
Introduced O(1) prime number lookup array
Trade-off: More memory for significantly better time complexity

Conclusion
For the 0.5-second time limit, O(N) complexity is required. The working solution achieves this by using additional memory to enable constant-time lookups.
</details>
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Main {

    static ArrayList<Integer> prime = new ArrayList<>();
    static int[] isPrime= new int[1000000];

    public static void main(String[] args) throws IOException {
        getPrime();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                return;
            } else {
                boolean flag= true;
                for (int i = 0; i < prime.size(); i++) {
                    if (isPrime[num-prime.get(i)]==1){
                        System.out.println(num + " = " + prime.get(i) + " + " + (num - prime.get(i))); flag=false;break;
                    }
                }if(flag){

                        System.out.println("Goldbach's conjecture is wrong.");

                }
            }
        }
    }

    public static void getPrime() {
        for (int i = 3; i < 1000000; i++) {
        boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prime.add(i);
                isPrime[i]=1;
            }
        }
    }
}
