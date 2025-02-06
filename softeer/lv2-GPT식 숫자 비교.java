/*
start: 11:45
end: 12:00

시간복잡도: O(N log N)  
- 입력을 받아 리스트에 저장하는 과정: O(N)  
- 정렬 과정: O(N log N)  
- 출력 과정: O(N)  
=> 전체적으로 O(N log N)  

공간복잡도: O(N)  
- 입력 데이터를 저장하는 리스트 사용: O(N)  
- 정렬 과정에서 추가적인 메모리 사용: O(N)  

풀이:  
1. 주어진 숫자 문자열을 "."을 기준으로 나누어 정수 배열로 변환하여 저장한다.  
2. `ArrayList<int[]>`를 사용하여 (x, y) 형태로 데이터를 저장한다.  
3. 정렬 기준:  
   - x 값을 기준으로 오름차순 정렬  
   - x 값이 동일하면 y 값을 기준으로 오름차순 정렬  
4. 정렬된 값을 출력하되, y 값이 -1이면 소수점 없이 출력하고, 그렇지 않으면 "x.y" 형태로 출력한다.  
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(stk.nextToken("\\."));
            int y=-1;
            if(stk.hasMoreTokens())
                y= Integer.parseInt(stk.nextToken("\\."));
            answer.add(new int[]{x,y});
        }
        answer.sort( (a,b )-> a[0]==b[0]? Integer.compare(a[1],b[1]): Integer.compare(a[0],b[0]));
        for(int[] nums: answer){
            if(nums[1]!=-1)
            System.out.println(nums[0]+"."+nums[1]);
            else{
                System.out.println(nums[0]);
            }
        }
    }
}
