import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        //입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(st.nextToken()));
            temp.add(Integer.parseInt(st.nextToken()));
            list.add(temp);
        }


        //정렬
        Collections.sort(list, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        //회의실 계산
        list1 = list.get(0);
        pQueue.add(list1.get(1));
        int result = 1;
        for (int i = 1; i < N; i++) {
            list1 = list.get(i);
            int startTime = list1.get(0); //지금 회의 시작시작
            int finishTime = pQueue.peek(); //전 회의 끝나는 시간
            //시작 시간이 전 회의 끝나는 시간보다 더 나중일 때 -> 회의실 추가 안해도됨
            if (finishTime <= startTime) {
                pQueue.poll();
            } else {
                result++;
            }
            pQueue.add(list1.get(1));
        }

        System.out.println(result);

    }
}
