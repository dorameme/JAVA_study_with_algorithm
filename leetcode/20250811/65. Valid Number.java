/*
start: 12:00
end: 12:54
시간복잡도: O(n)
공간복잡도: O(n)    // 방문 여부를 저장하는 배열과 재귀 호출 스택
풀이:
- 1부터 n까지의 숫자 중 k번째 순열을 구하는 문제
- 각 자리에 올 숫자를 '팩토리얼'을 이용하여 한 번에 건너뛰며 결정
- vis[] 배열로 사용한 숫자를 표시하여 중복 방지
- p(n): 팩토리얼 계산 함수
- num(start, k, idx):
    start: 현재 남은 순열 중에서 찾고자 하는 순서 번호
    k: 전체 숫자 개수
    idx: 현재 자리(1-based index)
    1) start가 0이면 남은 숫자를 큰 숫자부터 나열
    2) (k - idx)! 크기의 블록 단위로 몇 번째 숫자를 선택할지 결정
    3) 선택한 숫자를 결과 문자열에 붙이고 재귀 호출
*/

//더 개선된 풀이
class Solution {
public:  
        string getPermutation(int n, int k) {
        int fact[10]={1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        string nums="123456789";
        string res;
        k--;// k를 0-based index로 변환 (문제는 1-based)
        for(int i=n;i>=1;--i){
            int idx= k/fact[i-1];
            k %= fact[i-1];
            res.push_back(nums[idx]);
            nums.erase(nums.begin()+idx);
        }  
       return res;  
    }
};

class Solution {
public:
    bool vis[10];
    int p(int n){
        if(n<=1)return 1;
        return p(n-1)*n;
    }
    string num(int start ,int k,int idx){
        if(!start){
            string ans="";
            for(int i=k;i>=1;i--){
                if(!vis[i]){
                 ans= ans + to_string(i);
                }
            }
            return ans;
        }
        int number=0;
        long long plus= p(k-idx);
        int input=1;
        for(int i=1;i<=k;i++){
            if(vis[i]){
                continue;
            }
            number++;
            if(start > number * plus){
                continue;
            }
            if(start < number*plus){
                number--;
            }
            input= i;
            vis[input]=true;
            return to_string(input) + num(start- number *plus , k, idx+1);
        }   
        return "";
    }
    string getPermutation(int n, int k) {
       return num(k,n,1);
    }
};
