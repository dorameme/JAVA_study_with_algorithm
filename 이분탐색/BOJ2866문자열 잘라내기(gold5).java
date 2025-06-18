/*
start: 18:40
end: 19:38
시간복잡도: O(N * M)
공간복잡도: O(M * N) (map에 저장된 문자열 길이가 최대 N)

입력 크기 N이 작거나 중간 정도면 브루트포스가 직관적이고 구현도 쉬움.
입력 크기 N이 1000처럼 커질 경우 이분 탐색 풀이가 시간 면에서 훨씬 효율적임.
풀이: 브루트포스
- 아래에서부터 위로 한 줄씩 보면서 열 단위로 문자열을 쌓아간다.
- 한 줄을 추가할 때마다 모든 열에 대해 만들어지는 문자열을 확인하고,
  그 문자열이 이전에 등장한 적이 있는지 HashSet으로 검사한다.
- 중복이 발생한 줄의 개수를 세어, 전체에서 제외시켜 출력한다.

풀이: 이분탐색
시간복잡도: O(M * logN)
공간복잡도: O(M * N) (열별로 만들어지는 문자열을 저장)

- 가능한 최대 중복 행 수를 이분 탐색으로 찾는다.
- mid 만큼 아래에서부터 위로 문자열을 만들고,
  같은 열에서 만들어진 문자열이 중복되는지 확인한다.
- 중복이 있으면 더 많은 줄을 제거할 수 있으므로 left 증가,
  없으면 right 감소.
- 마지막으로 남은 최대 제거 가능한 줄 수를 기반으로 정답 출력.
*/
public class Main {

    static int N, M;
    static char[][] arr; // 석순
    static HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //결국 같은 문자열이 발생하는 가장 긴 애를 찾아야해.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        HashMap<Integer, String> map = new HashMap<>();


        for (int j = N - 1; j >= 0; j--) {
            boolean flag= true;
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < M; i++) {
                map.put(i, map.getOrDefault(i, "") + arr[j][i]);
                if(set.contains(map.get(i)) && flag){
                    ans++;
                    flag=false;
                }
                set.add(map.get(i));
            }
        }
        System.out.println(N-1-ans);
    }
}

//이분탐색

public class Main {

    static int N, M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        input();

        int l= 0;
        int r= N-1;
        int ans=0;
        while(l<=r){
            int mid =(l+r)/2;// 행
            if(solved(mid)){
                ans= mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(N-1-ans);
    }

    private static boolean solved(int mid) {
        HashSet<String> set= new HashSet<>();
        for(int i=0;i<M;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<mid;j++){
                sb.append(arr[N-1-j][i]);
            }
            if(set.contains(sb.toString())){
                return true;//같은게 있네...
            }
            set.add(sb.toString());
        }return false;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }
}
