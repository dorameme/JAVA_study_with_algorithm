/*
 * start:12:04
 * end:12:24
 * 시간복잡도:O(1)
 * 공간복잡도:O(1)
 * 풀이: "CCW(Counter Clock Wise)" 알고리즘을 사용하는 기하학 문제
 기본 개념:

Copy세 점이 이루는 방향은 벡터의 외적(Cross Product)으로 판단할 수 있음
- 외적 > 0: 반시계 방향 (CCW)
- 외적 < 0: 시계 방향 (CW)
- 외적 = 0: 일직선

구체적인 판단 방법:

Copy1) 벡터 두 개를 만든다:
   - 벡터 1: P1에서 P2로 가는 벡터
   - 벡터 2: P2에서 P3로 가는 벡터

2) 이 두 벡터의 외적을 구한다:
   - 2D에서는 다음 공식으로 계산:
   - CCW = (x2-x1)(y3-y1) - (y2-y1)(x3-x1)
 * */

import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int vector = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (vector == 0) {
            System.out.println(0);
        } else if (vector < 0) {
            System.out.println(-1);
        } else {
            System.out.println(1);
        }
    }
}
