package Study_codingtest.dongwook.week2.희소행렬;

class Term {
    int row;
    int col;
    int value;

    // Term 클래스의 생성자
    public Term(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

public class 희소행렬 {

    private static final int MAX_TERMS = 100;

    // 행렬 곱셈을 위한 메소드
    public static void mmult(Term[] a, Term[] b, Term[] d) {
        int totalD = 0;
        int rowsA = a[0].row, colsA = a[0].col, totalA = a[0].value;
        int colsB = b[0].col, totalB = b[0].value;
        int rowBegin = 1, row = a[1].row, sum = 0; // row: a의 현재 행
        Term[] newB = new Term[MAX_TERMS];

        if (colsA != b[0].row) {  // a의 열 수와 b의 행 수가 맞지 않으면 오류 발생
            System.err.println("Incompatible matrices");
            System.exit(1);
        }

        // b 행렬을 전치 행렬로 변환하여 newB에 저장
        fastTranspose(b, newB);

        // 경계 조건 설정
        a[totalA + 1].row = rowsA;
        newB[totalB + 1].row = colsB;
        newB[totalB + 1].col = 0;

        // 행렬 곱셈 수행
        for (int i = 1; i <= totalA; ) {
            int column = newB[1].row;  // b의 현재 열
            for (int j = 1; j <= totalB + 1; ) {
                if (a[i].row != row) {  // a 현재 행 벗어남
                    storeSum(d, totalD, row, column, sum);
                    i = rowBegin;  // a는 원 위치로, b는 다음 열(행)으로
                    while (newB[j].row == column) j++;  // b에서 현재 열을 넘김
                    column = newB[j].row;
                } else if (newB[j].row != column) {  // b 현재 열(행) 벗어남
                    storeSum(d, totalD, row, column, sum);
                    i = rowBegin;  // a는 원 위치
                    column = newB[j].row;  // b는 다음 열(행)으로
                } else {  // a[i].col == newB[j].col
                    if (a[i].col < newB[j].col) {
                        i++;  // a의 열이 더 작으면 a 증가
                    } else if (a[i].col > newB[j].col) {
                        j++;  // b의 열이 더 작으면 b 증가
                    } else {  // a[i].col == newB[j].col
                        sum += (a[i++].value * newB[j++].value);  // 값 계산 후, 둘 다 증가
                    }
                }
            }  // end of j loop

            // b의 모든 원소를 처리한 후, a[i]가 현재 행과 일치하지 않으면 넘어감
            while (a[i].row == row) i++;  // b의 모든 원소를 처리한 후
            rowBegin = i;  // 다음 행으로
            row = a[i].row;
        }  // end of i loop

        // 결과 행렬 d 설정
        d[0].row = rowsA;
        d[0].col = colsB;
        d[0].value = totalD;
    }

    // 전치 행렬 계산
    public static void fastTranspose(Term[] b, Term[] newB) {
        int[] rowTerms = new int[b[0].col + 1];
        int[] startPos = new int[b[0].col + 1];

        // 열에 해당하는 값 개수를 세기
        for (int i = 1; i <= b[0].value; i++) {
            rowTerms[b[i].col]++;
        }

        startPos[1] = 1;
        for (int i = 2; i <= b[0].col; i++) {
            startPos[i] = startPos[i - 1] + rowTerms[i - 1];
        }

        // 전치 행렬을 생성
        for (int i = 1; i <= b[0].value; i++) {
            int j = startPos[b[i].col]++;
            newB[j].row = b[i].col;
            newB[j].col = b[i].row;
            newB[j].value = b[i].value;
        }
    }

    // 합을 저장하는 메소드
    public static void storeSum(Term[] d, int totalD, int row, int column, int sum) {
        if (sum != 0) {
            if (totalD < MAX_TERMS) {
                d[++totalD].row = row;
                d[totalD].col = column;
                d[totalD].value = sum;
            } else {
                System.err.println("Numbers of terms in product exceeds " + MAX_TERMS);
                System.exit(1);
            }
        }
    }
}