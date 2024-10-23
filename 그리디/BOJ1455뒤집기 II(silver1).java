package 배열;
/*
 * start:16:50
 * end:17:01
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이:It's a greedy problem, and it's a matter of deciding whether or not to flip it, 
 starting from the bottom right corner and moving up to the top left.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N, C, W;
    static int[][] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int[] map=  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         coin=  new int[map[0]][map[1]];
        for(int i = 0; i < map[0]; i++) {
            coin[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
         int answer=0;
         for(int i=map[0]-1;i>=0;i--){
             for(int j=map[1]-1;j>=0;j--){
                 if(coin[i][j]==1){
                     answer++;
                     for(int a=0;a<=i;a++){
                         for(int b=0;b<=j;b++){
                             coin[a][b]=  coin[a][b]== 1? 0:1 ;
                         }
                     }
                 }
             }
         }
        System.out.println(answer);
    }
}
