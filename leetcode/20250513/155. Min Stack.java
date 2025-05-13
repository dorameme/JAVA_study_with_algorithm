/*
start:12:47  
end:13:17  
시간복잡도: O(1)  
공간복잡도: O(N)  
풀이:  
두 개의 스택을 사용한다.  
하나는 일반적인 스택 stack으로 값을 저장하고,  
다른 하나는 현재까지의 최소값만 저장하는 min 스택이다.

- 값을 push할 때는 기존의 최소값과 비교하여, 현재 값이 더 작거나 같으면 min 스택에도 함께 push한다.  
- 값을 pop할 때는, stack에서 값을 꺼낸 뒤, 그 값이 min의 top과 같다면 min에서도 pop하여 최소값을 동기화한다.  
- top()은 stack의 최상단 값을, getMin()은 min의 최상단 값을 반환한다.  
이로써 모든 연산을 O(1) 시간 내에 수행할 수 있다.
*/

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    Deque<Integer> stack ;
    Deque<Integer> min ;

    public MinStack() {
        min = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        
        stack.push(val);
        if(min.isEmpty() || min.peek()>= val)
        min.push(val);
    }

    public void pop() {

        int removed=stack.pop(); 
        if(removed == min.peek())min.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

