공부한 날짜 2024-05-18

1. 문자 배열로 스왑
class Solution {
    public void reverseString(char[] s) {
        char tmp;
        int size = s.length;
        for(int i=0;i<size/2;i++)
        {
            tmp = s[i];
            s[i]=s[size-i-1];
            s[size-i-1]=tmp;
        }

    }
}