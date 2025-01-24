class SMM{

    static final int MAX_TERMS = 100;

    static class Term {
        int row;
        int col;
        int value;

        Term(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        Term() {
            this(0, 0, 0);
        }
    }

    public static void mmult(Term[] a, Term[] b, Term[] d) {
        int totald = 0;
        int totala = a[0].value, totalb = b[0].value;
        int rowBegin = 1, row = a[1].row, sum = 0;

        Term[] newB = new Term[MAX_TERMS];
        for (int k = 0; k < MAX_TERMS; k++) {
            newB[k] = new Term();
        }

        if (a[0].col != b[0].row) {
            throw new IllegalArgumentException("Incompatible matrices");
        }

        fastTranspose(b, newB);

        a[totala + 1] = new Term(a[0].row, 0, 0);
        newB[totalb + 1] = new Term(b[0].col, 0, 0);

        for (int i = 1; i <= totala;) {
            int column = newB[1].row;

            for (int j = 1; j <= totalb + 1;) {
                if (a[i].row != row) {
                    storeSum(d, totald, row, column, sum);
                    sum = 0;
                    i = rowBegin;
                    while (j <= totalb && newB[j].row == column) j++;
                    column = newB[j].row;
                } else if (newB[j].row != column) {
                    storeSum(d, totald, row, column, sum);
                    sum = 0;
                    i = rowBegin;
                    column = newB[j].row;
                } else {
                    switch (compare(a[i].col, newB[j].col)) {
                        case -1 -> i++;
                        case 0 -> sum += a[i++].value * newB[j++].value;
                        case 1 -> j++;
                    }
                }
            }

            while (i <= totala && a[i].row == row) i++;
            rowBegin = i;
            row = a[i].row;
        }

        d[0] = new Term(a[0].row, b[0].col, totald);
    }

    private static void storeSum(Term[] d, int totald, int row, int column, int sum) {
        if (sum != 0) {
            if (totald < MAX_TERMS) {
                d[++totald] = new Term(row, column, sum);
            } else {
                throw new IllegalStateException("Number of terms in product exceeds " + MAX_TERMS);
            }
        }
    }

    private static void fastTranspose(Term[] b, Term[] newB) {
        int[] rowSize = new int[b[0].col + 1];
        int[] rowStart = new int[b[0].col + 1];

        for (int i = 1; i <= b[0].value; i++) {
            rowSize[b[i].col]++;
        }

        rowStart[0] = 1;
        for (int i = 1; i <= b[0].col; i++) {
            rowStart[i] = rowStart[i - 1] + rowSize[i - 1];
        }

        for (int i = 1; i <= b[0].value; i++) {
            int position = rowStart[b[i].col]++;
            newB[position] = new Term(b[i].col, b[i].row, b[i].value);
        }
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }
}
