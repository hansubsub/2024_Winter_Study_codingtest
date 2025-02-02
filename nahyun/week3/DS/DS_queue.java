class CreateQ {
    Object[] queue = new Object[Queue.MAX_Q_SIZE];
    int rear = -1; int front = -1;
}
public class Queue {
    static final int MAX_Q_SIZE = 100;
    public static void addq(CreateQ Q, Object item) {
        if (Q.rear >= MAX_Q_SIZE - 1) {
            System.out.println("queue full. add불가");
            return;
        }
        Q.queue[++Q.rear] = item;
    }
    public static Object deleteQ(CreateQ Q) {
        if(Q.front == Q.rear) {
            System.out.println("queue empty. delete불가");
            return null;
        }
        return Q.queue[++Q.front];
    }
    public static Boolean IsEmpty(CreateQ Q) {
        if(Q.rear == Q.front) return true;
        return false;
    }
    public static Boolean IsFull(CreateQ Q) {
        if(Q.rear >= MAX_Q_SIZE-1) return true;
        return false;
    }

    //테스트용 main함수
    public static void main(String[] args) {
        CreateQ queue = new CreateQ();

        Queue.addq(queue, "1");
        Queue.addq(queue, "2");
        Queue.addq(queue, "3");

        if (Queue.IsFull(queue)) {
            System.out.println("queueFull");
        } else {
            System.out.println("!queueFull");
        }

        System.out.println("delete: " + Queue.deleteQ(queue));
        System.out.println("delete: " + Queue.deleteQ(queue));

        if (Queue.IsEmpty(queue)) {
            System.out.println("queueEmpty");
        } else {
            System.out.println("!queueEmpty");
        }

        System.out.println("delete: " + Queue.deleteQ(queue));
        System.out.println("delete: " + Queue.deleteQ(queue)); // 큐 empty. delete불가
    }
}
