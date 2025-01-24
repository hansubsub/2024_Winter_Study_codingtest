import java.io.*;
import java.util.*;

public class Main {
    static class Document {
        int index, importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(nm.nextToken());
            int M = Integer.parseInt(nm.nextToken());

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayDeque<Document> queue = new ArrayDeque<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < N; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.addLast(new Document(i, importance));
                priorityQueue.add(importance);
            }

            int printOrder = 1;
            while (!priorityQueue.isEmpty()) {
                int currentMaxImportance = priorityQueue.poll(); //우선적으로 처리해야 할 중요도 번호
                //찾을 때까지 뒤로 미루기
                while (!queue.isEmpty()) {
                    Document doc = queue.pollFirst();
                    if (doc.importance == currentMaxImportance) { //그냥 처리하고 순서++
                        //System.out.println(first.index+"뽑음");
                        if (doc.index == M) {
                            sb.append(printOrder).append("\n");
                        }
                        printOrder++;
                        break;
                    } else {//뒤에 넣기
                        queue.addLast(doc);
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
