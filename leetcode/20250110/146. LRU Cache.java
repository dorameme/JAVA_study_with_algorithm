/*
start: 9:21  
end: 9:59  

시간복잡도:  
- `get`: O(1).  
  HashMap의 `containsKey`, `get`, `remove`, `put` 연산 모두 O(1)이다.  
- `put`: O(N).  
  HashMap에서 키의 존재를 확인하고, 필요시 오래된 항목을 제거하는 작업이 O(N)이다. -> 이는 마지막값을 참조하기 때문. 근데 어차피 capacity가 3000이라 괜찮다.

공간복잡도:  
- O(N).  
  N은 LRUCache의 최대 용량(capacity)이다. HashMap과 LinkedHashMap은 최대 N개의 키-값 쌍을 저장하므로, 공간복잡도는 O(N)이다.  

풀이:  
LRU 캐시는 HashMap과 LinkedHashMap을 활용해 구현되었다.  
1. `HashMap`을 사용해 O(1) 시간 복잡도로 키-값 조회 및 삽입을 처리한다.  
2. `LinkedHashMap`을 사용해 키의 삽입 순서를 유지하며 가장 오래된 항목을 관리한다.  
   - `get` 연산은 키가 존재할 경우 값을 반환하고, 해당 키를 가장 최근에 사용된 항목으로 갱신한다.  
   - `put` 연산은 키가 존재할 경우 기존 값을 갱신하고, 존재하지 않으면 새 키-값을 추가한다. 캐시 용량을 초과하면 가장 오래된 키를 제거한다.  
*/
class LRUCache {

    LRUCache arr;
    HashMap<Integer, Integer> dp = new LinkedHashMap<>();
    int len;

    public LRUCache(int capacity) {
        len = capacity;
    }

    public int get(int key) {
        int num = -1;
        if (dp.containsKey(key)) {
            num = dp.get(key);
            System.out.println(num);
            dp.remove(key); // 키를 제거했다가
            dp.put(key, num); // 다시 삽입하여 최신화
            return num;
        }
        return num;
    }

    public void put(int key, int value) {
        if (dp.containsKey(key)) {
            dp.remove(key); // 기존 키를 제거
        }
        dp.put(key, value); // 새 값 추가

        if (dp.size() > len) { 
            // 가장 오래된 항목 제거 (LinkedHashMap의 첫 번째 항목)
            int oldestKey = dp.keySet().iterator().next();
            dp.remove(oldestKey); // 오래된 키 제거
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
