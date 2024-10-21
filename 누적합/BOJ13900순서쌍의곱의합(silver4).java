/*
start:11:00
end:11:30
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 모든 값에 대한 두수를 골랐을때의 합을 출력해야하는데
단순히 N^N으로 풀면 시간초과가 난다.
따라서 공식을 이용하자! 공식은 img 디렉토리에 두수의곱전체 첨부해두었다.
쉽게 설명하자면 [ (모든 원소들의 합)^2 - ((각각의 원소^2) 의 합) ]/2 라는 ㅎ식으로 구할 수 있다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        Long[] arr = new Long[100001];

        StringTokenizer str = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(str.nextToken());
        }
        Long answer = 0L;
        Long minus = 0L;
        for (int i = 0; i < N; i++) {
            answer += arr[i];
            minus += arr[i] * arr[i];
        }
        System.out.println((answer * answer - minus)/2);
    }
}
