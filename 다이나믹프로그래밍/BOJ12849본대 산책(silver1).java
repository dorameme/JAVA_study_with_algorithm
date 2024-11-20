/*
 * start:19:45
 * enㅇ:19:59
 * 시간복잡도:O(V)
 * 공간복잡도:O(V*E*T) V=노드 수 E= 간선수 T=시간
 * 풀이:
주의할 점 long배열로 만들어줘야한다..  helper 가 연결된 dp들에게서 값을 받을때 int 범위를 넘어서기 때문이다
그게 싫으면 그냥.. helper 매번 나머지로 구해주면 됨.

 * */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Main {

    static int D;
    static ArrayList<int[]> node = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        node.add(new int[]{1, 2}); //0
        node.add(new int[]{0, 2, 3}); //1
        node.add(new int[]{0, 1, 3, 5});//2
        node.add(new int[]{1, 2, 4, 5});//3
        node.add(new int[]{3, 5, 6});//4
        node.add(new int[]{2, 3, 4, 7});//5
        node.add(new int[]{4, 7});//6
        node.add(new int[]{5, 6});//7
        long[][] dp = new long[8][100001];
        dp[0][0]=1;

        Scanner sc=new Scanner(System.in);
        D= Integer.parseInt(sc.next());
        for (int j = 1; j <= D; j++) {
            long[] helper = new long[8];
            for (int i = 0; i < 8; i++) {
                for (int k : node.get(i)) {
                    helper[i] += dp[k][j-1];
                }
            }
            for(int i=0;i<8;i++){
                dp[i][j]=helper[i];
                dp[i][j]%=1000000007;
            }
        }
        System.out.println(dp[0][D]);
    }
}

// 클린코드

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    private static final int MOD = 1_000_000_007; //이렇게 선언해두고 쓰자!
    private static final int[][] ADJACENT = {
        {1, 2},          // 0번 정점의 인접 정점들
        {0, 2, 3},       // 1번 정점의 인접 정점들
        {0, 1, 3, 5},    // 2번 정점의 인접 정점들
        {1, 2, 4, 5},    // 3번 정점의 인접 정점들
        {3, 5, 6},       // 4번 정점의 인접 정점들
        {2, 3, 4, 7},    // 5번 정점의 인접 정점들
        {4, 7},          // 6번 정점의 인접 정점들
        {5, 6}           // 7번 정점의 인접 정점들
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        
        // 현재 상태와 이전 상태만 저장하는 두 개의 배열 사용
        long[] current = new long[8];
        long[] next = new long[8];
        
        // 초기 상태 설정
        current[0] = 1;
        
        // D번 이동
        for (int move = 0; move < D; move++) {
            // 다음 상태 계산
            for (int vertex = 0; vertex < 8; vertex++) {
                next[vertex] = 0;
                // 현재 정점과 연결된 모든 정점에서 오는 경우의 수 합산
                for (int adj : ADJACENT[vertex]) {
                    next[vertex] = (next[vertex] + current[adj]) % MOD;
                }
            }
            
            // current와 next 배열 swap
            long[] temp = current;
            current = next;
            next = temp;
        }
        
        System.out.println(current[0]);
        br.close();
    }
}
