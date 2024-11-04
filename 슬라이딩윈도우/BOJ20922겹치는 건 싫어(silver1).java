/*
 * start:15:10
 * end:15:42
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:HashSet (java8)->merge를 쓰자!!
 * replace 메서드는 해당 키가 이미 존재할 때만 작동.
 * 처음 등장하는 숫자의 경우 키가 없어서 replace가 동작하지 않음.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {

    static int N, K;
    static Map<Integer, Integer> map= new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = s[0];
        K = s[1];
        int len = 0;
        int idx=0;
        int answer=0;
        for (int i = 0; i < nums.length; i++) {
           map.merge(nums[i],1,Integer::sum);
            len++;
            while(map.get(nums[i])>K){
                map.merge(nums[idx++],-1, Integer::sum);
                len--;
            }
            answer = Math.max(answer,len);
        }
        System.out.println(answer);
    }
}
