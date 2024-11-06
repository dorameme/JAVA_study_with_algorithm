/*
 * start:16:00
 * end:16:33
 * 시간복잡도: O(NlogN)
 * 공간복잡도:O(N)
 Long 객체는 == 연산자로 비교하면 참조 비교
 long 기본형은 == 연산자로 비교해도 값 비교
 가능하면 기본형 사용이 성능상 유리 -> 비교할때 되도록이면.==(참조비교)는 기본형으로 하자... 참조비교안일어나게 !!!

그리고 진짜 중요한 점은 마지막선분까지 제대로 계산되도록 해야한다는것!!!!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        ArrayList<Long[]> arr = new ArrayList<>((int) (N + 1));
        StringTokenizer stk;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr.add(new Long[]{Long.parseLong(stk.nextToken()), Long.parseLong(stk.nextToken())});
        }


        arr.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });
        Long start = arr.get(0)[0];
        Long end = arr.get(0)[1];

        long answer = 0;
        boolean flag=true;
        for (int i = 1; i < N; i++) {
            if (end < arr.get(i)[0]) {
                answer += end - start;
                start = arr.get(i)[0];
                end = arr.get(i)[1];
            } else {
                end = Math.max(end, arr.get(i)[1]);
                if (i == N - 1) {
                    flag =false;
                    answer += end - start;
                }
            }
        }
        if(flag){
            answer += end - start ;
        }
        System.out.println(answer);
    }
}

clean ver 
  import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<long[]> arr = new ArrayList<>(n);
        
        // 입력
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new long[]{
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken())
            });
        }
        
        // 시작점 기준 정렬
        arr.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });
        
        // 선분 합치기
        long start = arr.get(0)[0];
        long end = arr.get(0)[1];
        long answer = 0;
        
        for (int i = 1; i < n; i++) {
            if (end < arr.get(i)[0]) {  // 현재 선분과 떨어진 경우
                answer += end - start;
                start = arr.get(i)[0];
                end = arr.get(i)[1];
            } else {  // 현재 선분과 겹치는 경우
                end = Math.max(end, arr.get(i)[1]); 
            }
        } 
        answer += end - start;  // 마지막 선분 처리 --------------> 이부분 너무중요!!
         
        System.out.println(answer);
    }
}
