/*
start:15:20
end:15:34
시간복잡도:O(n)
공간복잡도;O(n)
풀이:
if (time <=opEnd && time>=opStart) {
             time=opEnd;
            }
  이렇게 시간을 매번 보정하는걸 모든 함수에 넣는거보단 next, prev함수에서 따로 빼서 solution이나 for문에서 한번만 쓰는게 나은듯.

*/

class Solution {

    int end;
    int opStart;
    int opEnd;

    public int prev(int time) {
        time -= 10;
        if (time < 0) {
            return 0;
        }
        return time;
    }

    public int next(int time) {
        time += 10;
        if (time > end) {
            return end;
        }
        return time;
    }

    public int getTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 +
            Integer.parseInt(time.substring(3, 5));
    }

    public String solution(String video_len, String pos, String op_start, String op_end,
        String[] commands) {
        opEnd = getTime(op_end);
        opStart = getTime(op_start);
        end= getTime(video_len);
        int time = getTime(pos);
        
        if (time <=opEnd && time>=opStart) {
            time = opEnd;
        }
        
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("prev")) {
                time = prev(time);
            } else {
                time = next(time);
            }
            if (time <=opEnd && time>=opStart) {
             time=opEnd;
            }//이부분이 위 '풀이'설명부분 
        }
        String minute=time%60+"";
        String hour=time/60+":";
        if (time / 60 < 10) {
            hour ="0"+hour;
        }
        if (time % 60 < 10) {
            minute ="0"+minute;
        }
        return hour + minute;
    }
}
