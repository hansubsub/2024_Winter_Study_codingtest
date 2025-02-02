public class Queue {
    int front;
    int rear;
    int [] queue;
    int size;

    //큐 생성
    public Queue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        queue = new int[size];
    }
    //Queue에 새로운 항목을 추가
    public void addq(int item) {
        if(rear>= size -1){
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = item;
    }
    //Queue의 항목을 return
    public int deleteq() {
        if (front == rear)
            System.out.println("Queue is empty");
        return queue[++front];
    }
    public static void main(String[] args){
        Queue queue = new Queue(3);
        queue.addq(1);
        queue.addq(2);
        queue.addq(3);
        queue.addq(4);

        queue.deleteq();
        queue.deleteq();
        queue.deleteq();
        queue.deleteq();
        queue.deleteq();
    }

    }
