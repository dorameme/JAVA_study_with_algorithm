/*
start:10:00
end:10:38
시간복집도:O(V^3)
공간복잡도:O(V^2)
풀이: 쉬운 플로이드워셜문제였다. 더 클린하게 짠 코드는 아래첨부!
그리고 stringTokenizer는 불필요하다..
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[50][50];
        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split(" is ");
            arr[s[0].charAt(0) - 'a'][s[1].charAt(0) - 'a'] = 1;
        }
        for (int i = 0; i <50; i++) {
            for (int j = 0; j <50; j++) {
                for (int k = 0; k < 50; k++) {
                    if (arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }
                }
            }
        }
        BufferedWriter bfw= new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(bf.readLine());// ->     int m = bf.readLine().trim().charAt(0)-'0'; 이렇게 써서 틀렸었다..이렇게하면 10의자리수는 받을 수 없다.
        for(int i=0;i<m;i++){
           String[] s= bf.readLine().split(" is ");
           if(arr[s[0].charAt(0)-'a'][s[1].charAt(0)-'a'] ==1){
               bfw.write("T\n");
           }
           else{
               bfw.write("F\n");}
        }bfw.flush();
    }
}




import java.io.*;
import java.util.*;

class Main {
   static final int ALPHABET_SIZE = 26;
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int n = Integer.parseInt(br.readLine());
       boolean[][] connected = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];//불리언 배열로 만들어준다.
       
       // 입력 처리
       for (int i = 0; i < n; i++) {
           String[] relation = br.readLine().split(" is ");
           int from = relation[0].charAt(0) - 'a';
           int to = relation[1].charAt(0) - 'a';
           connected[from][to] = true;
       }
       
       // 플로이드-워셜
       for (int k = 0; k < ALPHABET_SIZE; k++) {
           for (int i = 0; i < ALPHABET_SIZE; i++) {
               for (int j = 0; j < ALPHABET_SIZE; j++) {
                   if (connected[i][k] && connected[k][j]) {
                       connected[i][j] = true;
                   }
               }
           }
       }
       
       // 쿼리 처리
       int m = Integer.parseInt(br.readLine());
       for (int i = 0; i < m; i++) {
           String[] query = br.readLine().split(" is ");
           int from = query[0].charAt(0) - 'a';
           int to = query[1].charAt(0) - 'a';
           bw.write(connected[from][to] ? "T\n" : "F\n");
       }
       
       bw.flush();
       bw.close();
       br.close();
     ///항상 쓰고 닫아주자
     //close()는 필수는 아님
     //Java에서 JVM이 종료될 때 자동으로 리소스를 정리해주기 때문 다만, 메모리가 제한된 상황에서는 명시적으로 close()를 호출하는 것이 좋은 습관일 수 있다.
   }
}
