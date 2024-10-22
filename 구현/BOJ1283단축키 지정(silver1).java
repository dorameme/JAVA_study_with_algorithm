/*
 * start:19:20
 * end:19:58
 * 시간복잡도:O(NML)
 * 공간복잡도:O(1)
 * 풀이: This is a simple implementation problem using strings, 
 and I solved it by duplicating the code instead of creating a function to make it faster, 
 but it would be much more readable to break it up into functions.
 
 Arrays.stream(s).forEach(bw::write);
does not work because of the following reasons
Exception handling issues:
TheBufferedWriter.write() method can throw an IOException.
The lambda expression inforEachcannot throw a checked exception.
Therefore, you cannot use bw::writeas a direct method reference.
Whitespace handling issues:
When you simply call write(), there are no spaces between words.
In the current code, you need to add a space to each word.
 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] option = new int[200];
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                if (option[s[j].charAt(0)] == 0) {
                    flag = true;
                    char upperCase = Character.toUpperCase(s[j].charAt(0));
                    char lowerCase = Character.toLowerCase(s[j].charAt(0));
                    option[upperCase] = 1;
                    option[lowerCase] = 1;

                    s[j] = "[" + s[j].charAt(0) + "]" + s[j].substring(1);
                    String[] array = Arrays.stream(s).map(x -> x + " ").toArray(String[]::new);
                    for (String str : array) {
                        bw.write(str);
//                    Arrays.stream(s).forEach(bw::write); 안되는이유?
                    }
                    bw.write("\n");
                    break;
                }
            }
            if (flag == false) {
                for (int j = 0; j < s.length && flag == false; j++) {
                    for (int k = 0; k < s[j].length(); k++) {
                        if (option[s[j].charAt(k)] == 0) {
                            flag = true;
                            char upperCase = Character.toUpperCase(s[j].charAt(k));
                            char lowerCase = Character.toLowerCase(s[j].charAt(k));
                            option[upperCase] = 1;
                            option[lowerCase] = 1;
                            s[j] = s[j].substring(0, k) + "[" + s[j].charAt(k) + "]" + s[j].substring(
                                    k + 1);
                            String[] array = Arrays.stream(s).map(x -> x + " ")
                                .toArray(String[]::new);
                            for (String str : array) {
                                bw.write(str);
                            }
                            bw.write("\n");
                            break;
                        }
                    }
                }
            }
            if (flag == false) {
                String[] array = Arrays.stream(s).map(x -> x + " ").toArray(String[]::new);
                for (String str : array) {
                    bw.write(str);
//                    Arrays.stream(s).forEach(bw::write); 안되는이유? 
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

