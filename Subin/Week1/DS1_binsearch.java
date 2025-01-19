//이진 검색의 재귀 알고리즘 자바에는 COMPARE이 없으므로 Integer.compare을 이용함
public class Main {
    public static int binsearch(int[] list, int searchnum, int left, int right ) {
        if (left <= right) {
            int middle = (left + right) / 2;

            switch (Integer.compare(list[middle], searchnum)) {
                case -1: //<이면 middle+1로 binsearch
                    return binsearch(list, searchnum, middle + 1, right);
                case 0:
                    return middle;
                case 1: // >이면 middle-1로 binsearch
                    return binsearch(list, searchnum, left, middle - 1);
            }
        }
        return -1;
    }



        /*
        C언어: 이진 검색의 재귀 알고리즘
        int binsearch(int list[], int searchnum, int left, int right){
        int middle;
        if(left<=right){    //경계조건
            middle = (left+ right)/2;
        switch(COMPARE(list[middle],searchnum)){
                case-1: return
                    binesearch(list, searchnum, middle+1, right);
                case 0: return middle;
                case 1: return
                binsearch(list, searchnum, left, middel-1);
         }
         }
         return -1;
        }

         */
