/*
start:21:11
end:21:23
시간복잡도:O(N)
공간복잡도:O(N)
풀이:사실상 자릿수가 다르면 그냥 8이 아예못나온다..
 따라서 앞에서부터 같은자리수이고 && 같은 수를 가짐 을 만족하는 동안에 각자리수가 둘다 8임을 만족하는 개수를 구하는 문제!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int sizeA = getSize(s[1]);
        int sizeB = getSize(s[0]);
        int answer = 0;
        if (sizeA == sizeB) {
            String a = String.valueOf(s[1]);
            String b = String.valueOf(s[0]);
            for (int i = 0; i < sizeA; i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    if (a.charAt(i) == '8') {
                        answer++;
                    }
                    continue;
                }
                break;
            }
        }
        System.out.println(answer);
    }


    public static int getSize(long a) {
        if (a == 0) {
            return 0;
        } else {
            return getSize(a / 10) + 1;
        }
    }
}
