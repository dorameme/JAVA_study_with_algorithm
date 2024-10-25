/*
 * start:15:33
 * end:15:54
 * 시간복잡도:Prime check: O(√i) & Palindrome check: O(log i) 
 * 공간복잡도:O(log i) 
 * 풀이: 
 key point!
 // Palindrome Check Method
- Convert number to string
- Compare characters from start and end moving inward
- Return false if any mismatch found

// Prime Check Method
- Handle special cases (1 and 2)!!! -> this one is sooooo importent!!!!
- Check divisibility up to square root of number
- Return false if any divisor found
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        for(int i=N;;i++){
            if (팰린드롭(i) && 소수(i)) {
                System.out.println(i);
                return ;
            }
        }
    }

    public static boolean 팰린드롭(Integer num) {
        String str = num.toString();
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean 소수(Integer num) {
        if(num==1)return false;
        if(num==2)return true;///소수는 항상 1과 2 를 따로 다루어줘야한다.
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
