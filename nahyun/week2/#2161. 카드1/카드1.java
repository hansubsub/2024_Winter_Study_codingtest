import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i<=N; i++) {
            list.add(i);
        }

        while(list.size() != 1) {
            int removeCard = list.remove(0);
            sb.append(removeCard).append(" ");
            int moveCard = list.remove(0);
            list.add(moveCard);
        }
        sb.append(list.remove(0));

        System.out.println(sb);
    }
}
