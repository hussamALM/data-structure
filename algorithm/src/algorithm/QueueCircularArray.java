package algorithm;

public class QueueCircularArray {

    Node list[];
    int front;
    int rear;
    int size;

    QueueCircularArray(int size) {
        front = rear = -1;
        list = new Node[size];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("the list is full");
            return;
        }
        if (isEmpty()) {
            front++;
        }
        rear = (rear + 1) % list.length;

        list[rear] = new Node(data);
        this.size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (rear == front) {
            front = rear = -1;
            this.size--;
        } else {
            list[front] = null;
            front = (front + 1) % list.length;
            this.size--;
        }

    }

    public void top() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        System.out.println("the first element is: " + list[front]);
    }

    public void size() {
        System.out.println("the size is: " + this.size);
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;

        }
        for (int i = front; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println(list[i]);
            }
        }
        for (int i = rear; i < 0; i--) {
            if (list[i] != null) {
                System.out.println(list[i]);
            }
        }

    }

    public boolean isEmpty() {

        return front == -1;

    }

    public boolean isFull() {

        return (rear + 1) % list.length == front;

    }
}
