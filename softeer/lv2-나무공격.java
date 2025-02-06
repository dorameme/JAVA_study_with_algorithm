/*
start:13:38
end:13:58
시간복잡도:O(NM)
공간복잡도:O(NM)
풀이: attack 배열을 둬서 남은 공격수 만큼 1을 만났을때 소비 
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk= new StringTokenizer(br.readLine());

        int N= Integer.parseInt(stk.nextToken());
        int M= Integer.parseInt(stk.nextToken());
        int[][] arr= new int[N][M];
        int answer=0;
        for(int i=0;i<N;i++){
             stk= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=  Integer.parseInt(stk.nextToken());
                if(arr[i][j]==1)answer++;
            }
        }
        int[] attack= new int[N];
        for(int i=0;i<2;i++){
             stk= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(stk.nextToken())-1;
            int y= Integer.parseInt(stk.nextToken())-1;
            for(int j=x;j<=y;j++){
                attack[j]++;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1 && attack[i]>0){attack[i]--; answer--;} 
            }
        }
        System.out.println(answer);
    }
}
