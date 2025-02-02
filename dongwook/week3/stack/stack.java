public class stack {
    private static final int MAX_STACK_SIZE = 10;
    private int top = -1;
    private int[] stack = new int[MAX_STACK_SIZE];

    // 스택에 항목을 추가하는 함수
    public void push(int item) {
        if (top >= MAX_STACK_SIZE - 1) {
            System.out.println("스택이 꽉 찼습니다.");
            return;
        }
        stack[++top] = item;
    }

    // 스택에서 항목을 제거하는 함수
    public int pop() {
        if (top == -1) {
            System.out.println("스택이 비어있습니다.");
            return -1; // 스택이 비어있으면 -1 반환
        }
        return stack[top--];
    }
}
