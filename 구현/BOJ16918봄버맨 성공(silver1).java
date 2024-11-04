/*
 * start:13:50
 * end:14:14
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이:항상 잘 안풀리면 .. 문제를 정확히 읽자 -.-
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    static int R, C, N;
    static String[] arr;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<int[]> bomb=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = s[0];
        C = s[1];
        N = s[2];
        map = new char[R][C];
        for (int i =0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for(int i=1;i<=N;i++){
           if(i==1) findBomb();
           else if(i%2==0){
               findBomb();
               putBomb();
           }
           else if(i%2==1)explode();
           else if(i==0);
        }
        printArr();
    }

    static void findBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    bomb.add(new int[]{i, j});
                }
            }
        }
    }

    static void putBomb() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = 'O';
            }
        }
    }

    static void explode() {
        while (!bomb.isEmpty()) {
            int[] newBomb = bomb.remove(0);
            for (int i = 0; i < 4; i++) {

                int nx= newBomb[0]+dx[i];
                int ny= newBomb[1]+dy[i];
                if(nx<0||ny<0||nx>=R||ny>=C)continue;
                map[nx][ny]='.';
            }
            map[newBomb[0]][newBomb[1]]='.';
        }

    }

    static void printArr() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
