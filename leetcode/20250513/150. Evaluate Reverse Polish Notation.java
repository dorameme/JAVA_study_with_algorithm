/*
start:13:14
end:13:28
시간복잡도:O(1)
공간복잡도:O(N)
풀이: case문으로 나누는게 더 가독성이 좋고 
정해져있는 연산자 외에 
숫자가 나온경우는 default로 처리해주는 것이좋다.

*/
//개선된 풀이
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        
        for(String token : tokens){
            switch(token){
                case "+" ->{
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left+right);
                }
                case "-"->{
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left-right);
                }
                case "/" ->{

                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left/right);
                }
                case "*"->{
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left*right);
                }
                default ->{
                    stack.push(Integer.parseInt(token));
                }
            }
        }return stack.pop();
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        
        for(int i=0;i<tokens.length;i++){
            if(Character.isDigit(tokens[i].charAt(tokens[i].length()-1))){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int m= stack.pop();
                int n=  stack.pop();
                if(tokens[i].equals("/")){
                    stack.push(n/m);
                }
                else if(tokens[i].equals("*")){
                    stack.push(n*m);
                }
                else if(tokens[i].equals("+")){
                    stack.push(n+m);
                }
                else if(tokens[i].equals("-")){
                    stack.push(n-m);
                }
            }
        }return stack.pop();
    }
}
