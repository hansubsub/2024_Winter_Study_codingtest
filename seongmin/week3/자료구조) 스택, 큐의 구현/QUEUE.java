class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == size - 1) {
            System.out.println("queue full");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = value;
    }

    public int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("queue empty");
            return -1;
        }
        return queue[front++];
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
}
