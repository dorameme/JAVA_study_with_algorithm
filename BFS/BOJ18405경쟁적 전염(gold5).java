/*
 * start:16:30
 * end:16:50
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이: BFS문제였고 주의할 점을 써보자면.. 

사용자 정의 클래스나 배열을 사용할 때
PriorityQueue<int[]>에 비교기준을 써주어야 한다는 것을 깜박했다. (미작성시 RuntimeException이 난다)
기본 타입이나 String처럼 Comparable을 구현한 클래스의 경우는 생략가능하다.

 그리고 가끔 인덱스가 0이아닌 1로 시작하는 문제가 있는데 
 이번문제가 그런문제였다 주의주의하자!!

 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int[][] map = new int[201][201];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> helper = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new int[]{map[i][j], i, j});
                }
            }
        }
        stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());
        int Y = Integer.parseInt(stk.nextToken());
        int[] dx={0,-1,1,0};
        int[] dy={1,0,0,-1};
        while (S--!=0){
            while(!pq.isEmpty()){
                int[] cur= pq.poll();
                for(int i=0;i<4;i++){
                    int nx= dx[i]+cur[1];
                    int ny= dy[i]+cur[2];
                    int sort= cur[0];
                    if(nx<=0||ny<=0||nx>N||ny>N)continue;
                    if(map[nx][ny]==0){
                        map[nx][ny]=sort;
                        helper.add(new int[]{sort,nx,ny});
                    }
                }
            }
            pq.clear();
            pq.addAll(helper);
            helper.clear();
        }
        System.out.println(map[X][Y]);
    }
}
//clean ver
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Virus {
        int type, x, y;
        
        Virus(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
    
    static int N;
    static int[][] map;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        
        // 바이러스 타입으로 정렬되는 우선순위 큐
        PriorityQueue<Virus> viruses = new PriorityQueue<>((a, b) -> a.type - b.type);
        
        // 맵 입력 받기
        initializeMap(br, viruses);
        
        // S, X, Y 입력 받기
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());
        int Y = Integer.parseInt(stk.nextToken());
        
        // 바이러스 확산 시뮬레이션
        simulateVirusSpread(S, viruses);
        
        System.out.println(map[X][Y]);
    }
    
    private static void initializeMap(BufferedReader br, PriorityQueue<Virus> viruses) throws IOException {
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] != 0) {
                    viruses.add(new Virus(map[i][j], i, j));
                }
            }
        }
    }
    
    private static void simulateVirusSpread(int seconds, PriorityQueue<Virus> viruses) {
        while (seconds-- > 0 && !viruses.isEmpty()) {
            PriorityQueue<Virus> nextViruses = new PriorityQueue<>((a, b) -> a.type - b.type);
            
            // 현재 시간에 존재하는 모든 바이러스에 대해 확산 진행
            spreadCurrentViruses(viruses, nextViruses);
            
            viruses = nextViruses;
        }
    }
    
    private static void spreadCurrentViruses(PriorityQueue<Virus> viruses, PriorityQueue<Virus> nextViruses) {
        while (!viruses.isEmpty()) {
            Virus current = viruses.poll();
            
            // 4방향으로 확산
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (isValidPosition(nx, ny) && map[nx][ny] == 0) {
                    map[nx][ny] = current.type;
                    nextViruses.add(new Virus(current.type, nx, ny));
                }
            }
        }
    }
    
    private static boolean isValidPosition(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= N;
    }
}
