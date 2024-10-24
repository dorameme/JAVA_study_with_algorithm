/*
 * start:21:39
 * end:22:42
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:There were many factors to consider
However, there is an easier approach to solving this, which I will include below

The problem description asks to count the number of zeros.
In cases like this,
it seems that following the approach suggested in the problem directly is often the easiest way to solve it.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static int M;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int cnt = 1;
        int answer = 0;
        int turn = 1;// I =1 0=2
        for (int i = 0; i < M; i++) {
            if (s[i] == 'O') {
                if (turn == 2) {
                    cnt++;
                    turn = 1;
                } else {//IOIOO  5// IOIOIOIOO 9 -> 3개...
                    answer += Math.max((cnt - 2) / 2 - N + 1, 0);
                    turn = 1;
                    cnt = 0;
                }
            } else {
                if (turn == 1) {//만일 I의 차례라면..
                    cnt++;
                    turn = 2;
                } else {//니차례아니야! IOIOII
                    answer += Math.max((cnt - 1) / 2 - N + 1, 0);
                    turn = 2;
                    cnt = 1;//warning! -> Note that it must restart from 1, not 0
                }
            }
        }
        if (turn == 1) {//다음이 I IOIO
            System.out.println(answer + Math.max((cnt-2) / 2 - N+1, 0));
        } else {//다음이 O IOIOIOI
            System.out.println(answer + Math.max((cnt-1) / 2 - N+1, 0));
        }
    }
}





//clean code
/*
 * start:21:39
 * end:12:00
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static int M;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int answer = 0;
        int cnt=0;
        for (int i = 1; i < M-1; i+=2) {
            if(s[i-1]=='I' && s[i]=='O' && s[i+1]=='I'){
                cnt++;
                if(cnt==N){
                    cnt--;
                    answer++;
                }
            }
            else{
                cnt=0;
                i--;
            }
        }
        System.out.println(answer);
    }
}
