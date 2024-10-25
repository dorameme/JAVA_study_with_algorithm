
/*
 * start:10:00
 * end:10:45
 * 시간복잡도 :O(log(max(x,y)))
 * 공간복잡도:O(1)
 * 풀이:Time Complexity Analysis & Solution Summary:

Time Complexity: O(log(max(x,y))) due to Euclidean algorithm for GCD calculation
Solution: Count the tiles crossed by diagonal in x×y grid using formula (x + y - GCD(x,y)), 
where GCD represents number of grid points minus 1 that diagonal line intersects with, thereby avoiding double counting at intersection points.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static long x;
    static long y;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        x=num[0];
        y=num[1];
        System.out.println(x+y - getGCD(x,y));
    }

   public static long getGCD(long a ,long b){
        while(b!=0){
            long tmp= a%b;
            a=b;
            b=tmp;
        }
        return a;
   }
}
