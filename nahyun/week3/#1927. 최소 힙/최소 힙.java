import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pQueue.isEmpty()) { sb.append(0).append('\n'); }
                else { sb.append(pQueue.poll()).append('\n'); }
           }
           else {
               pQueue.add(x);
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
