import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    희소 행렬의 곱셈
    
    <입력>
    행렬 A     행렬 B
    3 3 4      3 2 3
    0 0 1      0 0 5
    0 1 2      1 1 6
    1 0 3      2 0 7
    2 2 4
    
    <출력>
    3 2 4
    0 0 19
    0 1 12
    1 0 15
    2 0 28
*/

//<row, column, value> 쌍 저장할 클래스
class Term {
    int col; int row; int value;
    //생성자
    public Term(int row, int col, int value) {
        this.col = col;
        this.row = row;
        this.value = value;
    }
}
public class SparseMatrixMul {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Term[] a = new Term[50];
        Term[] b = new Term[50];
        Term[] d = new Term[50];
        for (int i = 0; i < 50; i++) {
            d[i] = new Term(0, 0, 0);
        }

        // 행렬 A 입력
        System.out.println("행렬 A의 행, 열, 값의 개수 :");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aRow = Integer.parseInt(st.nextToken());
        int aCol = Integer.parseInt(st.nextToken());
        int aValue = Integer.parseInt(st.nextToken());
        a[0] = new Term(aRow, aCol, aValue);

        System.out.println("행렬 A의 값 : ");
        for (int i = 1; i <= aValue; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            a[i] = new Term(row, col, value);
        }

        // 행렬 B 입력
        System.out.println("행렬 B의 행, 열, 값의 개수 : ");
        st = new StringTokenizer(br.readLine());
        int bRow = Integer.parseInt(st.nextToken());
        int bCol = Integer.parseInt(st.nextToken());
        int bValue = Integer.parseInt(st.nextToken());
        b[0] = new Term(bRow, bCol, bValue);

        System.out.println("행렬 B의 값 : ");
        for (int i = 1; i <= bValue; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            b[i] = new Term(row, col, value);
        }

        // d에 행렬 곱셈 결과 저장
        mmult(a, b, d);

        // 결과 출력
        System.out.println("행렬 곱셈 결과 : ");
        for (int i = 0; i <= d[0].value; i++) {
            System.out.println(d[i].row + " " + d[i].col + " " + d[i].value);
        }
    }
    //빠른 전치행렬 개선버전
    //a의 전치행렬 -> b
    public static void FastTranspose(Term a[], Term[] b) {
        int[] rowTerms = new int[50];
        //총 열의 개수, 0이 아닌 원소의 총 개수
        int numCol = a[0].col;
        int numTerms = a[0].value;

        b[0].row = numCol;
        b[0].col = a[0].row;
        b[0].value = numTerms;

        if(numTerms > 0) {
            //초기화
            for(int i = 0; i<numCol; i++) {
                rowTerms[i] = 0;
            }
            //각 열 원소 수 계산
            for(int i = 1; i<=numTerms; i++) {
                rowTerms[a[i].col]++;
            }
            //starting_pos설정
            int temp1 = 1; int temp2;
            for(int i = 0; i<numCol; i++) {
                temp2 = rowTerms[i];
                rowTerms[i] = temp1;
                temp1 += temp2;
            }
            //전치행렬 만들어서 b에 저장
            int in;
            for(int i = 1; i<=numTerms; i++) {
                in = rowTerms[a[i].col]++;
                b[in].row = a[i].col;
                b[in].col = a[i].row;
                b[in].value = a[i].value;
            }
        }
    }

    public static void mmult(Term[] a, Term[] b, Term[] d) {
        int totala = a[0].value;
        int totalb = b[0].value;
        int totald = 0;
        //rowBegin은 행시작점, row는 a의 현재 행을 나타냄
        int rowBegin = 1;
        int row = a[1].row;
        int sum = 0;
        Term[] newB = new Term[50];
        for (int i = 0; i < 50; i++) {
            newB[i] = new Term(0, 0, 0);
        }

        if (a[0].col != b[0].row) {
            System.err.println("조건 잘못됨. a의 열 수와 b의 행 수는 같아야함");
            System.err.println("a[0].col: " + a[0].col + ", b[0].row: " + b[0].row);
        }
        FastTranspose(b, newB); //b의 전치행렬을 newB에 저장
        //경계조건. 다 돌았다는 것을 확인하여 종료하기 위해
        a[totala + 1] = new Term(0, 0, 0);
        a[totala + 1].row = a[0].row;

        newB[totalb + 1] = new Term(0, 0, 0);
        newB[totalb + 1].row = b[0].col;

        int column;
        for(int i = 1; i<=totala; ) {
            column = newB[1].row;
            for(int j = 1; j<=totalb+1; ) {
                if(a[i].row != row) { //a의 현재 행을 벗어남
                    totald = storesum(d, totald, row, column, sum);
                    sum = 0;
                    i = rowBegin; //a 원위치! b는 다음 열로. 아직 남아있을 수도 있음
                    for(;newB[j].row == column; j++);
                    column = newB[j].row;
                }
                else if(newB[j].row != column) { //b가 현재 열 벗어남
                    totald = storesum(d, totald, row, column, sum);
                    sum = 0;
                    i = rowBegin;
                    column = newB[j].row;
                }
                //어떤 쪽을 진행시킬까?
                else switch(Integer.compare(a[i].col, newB[j].col)) {
                        case -1: //a[i].col이 더 작음 -> a 증가
                            i++;break;
                        case 0: //같음. 곱한 후에 a와 b 모두 증가
                            sum += (a[i++].value * newB[j++].value); break;
                        case 1 : //b[j].col이 더 작음 -> b 증가
                            j++; break;
                    }
                }
            for(; a[i].row == row; i++); //b 남은 원소 처리
            rowBegin = i; row = a[i].row;
            }
        d[0].row = a[0].row;
        d[0].col = b[0].col;
        d[0].value = totald;
        }
        //d에 저장
        public static int storesum(Term[] d, int totald, int row, int column, int sum) {
            if(sum != 0) {
                if(totald < 50) {
                    d[++totald] = new Term(row, column, sum);
                }
                else System.err.println("허용 길이 초과");
            }
            return totald;
        }
    }
