/*
 * start:13:14
 * end:13:56
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:The question asked for a distance to be measured,

One thing to note about this problem is that 
// System.out.println(" "+x+dx);// Don't forget to organize this!
I didn't get the answer because I was using this kind of code, but “ ”+ x +dx means that x +dx is calculated as a string, so 
” ”+ (x +dx) I had to write something like this
 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int targetX, targetY;
    static int x, y, dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        targetX = target[0];
        targetY = target[1];
        x = now[0];
        y = now[1];
        dx = now[2];
        dy = now[3];
        for (int i = 2; i<=100; i++) {
            if (dx % i == 0 && dy % i == 0) {
                dx /= i;
                dy /= i;
            }

        }
        while (distanceSquared(x, y) > distanceSquared(x + dx, y + dy)) {
            x += dx;
            y += dy;
        }
      System.out.println(x + " " + y);
    }

    public static int distanceSquared(int x, int y) {
        return (targetX - x) * (targetX - x) + (targetY - y) * (targetY - y);
    }
}
