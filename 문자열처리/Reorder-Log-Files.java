공부한 날짜 2024-05-19

1. 문자로그와 숫자로그를 구분해 각각 처리
    point: split 함수에 인자로 뒤에 숫자를 넣어주면 배열 크기를 조절할 수 있다.
    sort할때 람다식을 사용하면 더 편리하다. 예를들어
    Collections.sort(~~) 이게 아니라, letterList.sort(s1,s2->->{
        ~~~
    }); 이렇게 하면 간단한 람다식으로 복잡한 구문이 정리가능하다.
class Solution {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList= new ArrayList<>();
        List<String> numberList=new ArrayList<>();
        for(int i=0;i<logs.length;i++){
            String str = logs[i];
            if(Character.isDigit(str.split(" ")[1].charAt(0))){
                numberList.add(str);
            }
            else{
                letterList.add(str);
            }
        }
        // Collections.sort(letterList,new Comparator<String>(){
        //     @Override
        //     public int compare(String s1,String s2){
        //         String[] s1x= s1.split(" ",2);
        //         String[] s2x = s2.split(" ",2);

        //         int compared = s1x[1].compareTo(s2x[1]);
        //         if(compared == 0 ){
        //             return s1x[0].compareTo(s2x[0]);
        //         }
        //         else{
        //             return compared;
        //         }
        //     }
        // });
        letterList.sort((s1,s2)->{
            String[] s1x = s1.split(" ",2);
            String[] s2x = s2.split(" ",2);
            int compared= s1x[1].compareTo(s2x[1]);
            if(compared==0){
                return s1x[0].compareTo(s2x[0]);

            }else return compared;
        });

        letterList.addAll(numberList);
        return letterList.toArray(String[]::new);
    }
}