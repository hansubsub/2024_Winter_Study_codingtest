class CreateS {
    Object[] stack = new Object[Stack.MAX_STACK_SIZE];
    int top = -1;
}

public class Stack {
    static final int MAX_STACK_SIZE = 100;

    public static void push(CreateS S, Object item) {
        if(S.top>=(MAX_STACK_SIZE-1)) {
            System.out.println("스택이 가득찼음");
            return;
        }
        S.stack[++S.top] = item;
    }
    public static Object pop(CreateS S) {
        if(S.top == -1) {
            System.out.println("스택이 비어있음");
            return null;
        }
        return S.stack[S.top--];
    }
    public static Boolean IsEmpty(CreateS S) {
        if(S.top < 0) return true;
        return false;
    }
    public static Boolean IsFull(CreateS S) {
        if(S.top>=(MAX_STACK_SIZE-1)) return true;
        return false;
    }


    //테스트용 메인함수
    public static void main(String[] args) {
        CreateS stack = new CreateS();

        Stack.push(stack, "1");
        Stack.push(stack, "2");
        Stack.push(stack, "3");

        if (Stack.IsFull(stack)) {
            System.out.println("stackFull");
        } else {
            System.out.println("!stackFull");
        }

        System.out.println("pop: " + Stack.pop(stack));
        System.out.println("pop: " + Stack.pop(stack));

        if (Stack.IsEmpty(stack)) {
            System.out.println("stackIsEmpty");
        } else {
            System.out.println("!stackIsEmpty");
        }

        System.out.println("pop: " + Stack.pop(stack));
        System.out.println("pop: " + Stack.pop(stack)); //스택 비어있는 상태. null

    }
}
