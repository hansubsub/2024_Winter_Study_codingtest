public class Stack {
    int top;
    int size ;
    int [] stack;
    //스택 생성
    public Stack(int size) {
        top = -1; //스택 포인터 초기화
        this.size = size;
        stack = new int[size]; //size의 배열생성
    }
    //스택 push
    public void push(int item) {
        if(top>=size-1){
            System.out.println("Stack is full");
        }
        else{
            stack[++top] = item;
        }
    }
    //스택 pop
    public int pop() {
        if(top==-1)
            System.out.println("Stack is empty");
        return stack[top--];
    }
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4); //full 출력

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); //empty 출력

    }
}

