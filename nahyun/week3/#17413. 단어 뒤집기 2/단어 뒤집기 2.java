import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        int i = 0;
        while(i<str.length) {
            if(str[i].equals(" ")) {
                sb.append(str[i++]);
            }
            else if(str[i].equals("<")) {
                while(!str[i].equals(">")) {
                    sb.append(str[i++]);
                }
                sb.append(str[i++]); //">"도 sb에 넣어주기
            }
            else {
                while(i<str.length && !str[i].equals(" ") && !str[i].equals("<")) {
                    stack.add(str[i++]);
                }
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}
