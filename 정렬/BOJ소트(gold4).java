/*
start: 14:00  
end: 14:25  
시간복잡도: O(N^2)  
공간복잡도: O(N)  (리스트 사용)
풀이:  S는 최대 스왑 가능 거리로, 단 한 번에 자리를 바꿀 수 있는 게 아니라  
     인접한 자리끼리만 스왑이 가능하다. 즉, 하나씩 이동해야 함.
   따라서 현재 위치에서 S 안쪽까지 가장 큰 수를 찾아서 앞으로 이동시키고,  
   그 과정에서 사용한 스왑 횟수를 S에서 차감한다.
  주의할건 자리가 바뀌면 a<b<c<d 일때 a,d가 자리가 바뀌는게 아니라 하나씩 스왑하는거니까 d<a<b<c이런형식으로 바뀐다~~~~!!!

*/
class Main {

    static int[] arr;
    static int T, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        arr = new int[T];
       List<Integer> arr=new LinkedList<>();
        for (int i = 0; i < T; i++) {
            arr.add(Integer.parseInt(stk.nextToken()));
        }
        S = Integer.parseInt(br.readLine());

        int idx = 0;
        while (idx< T) {
            int biggest = arr.get(idx);
            int changeIdx = idx;
            for (int i = idx + 1; i < T && i - idx <= S; i++) {
                if (biggest <arr.get(i)) {
                    biggest = arr.get(i);
                    changeIdx = i;
                }
            }
            if (biggest == arr.get(idx)) {
                idx++;
                continue;
            } else {
                int tmp = arr.get(idx);
                int tmp2= arr.get(changeIdx);
                arr.add(idx, tmp2);
                arr.remove(changeIdx+1);
                S= S-(changeIdx-idx);
                idx++;
            }

        }
       for(int a:arr){
           System.out.print(a+" ");
       }
    }
}
