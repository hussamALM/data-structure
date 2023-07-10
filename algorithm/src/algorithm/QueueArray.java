package algorithm;

public class QueueArray {

    Node list[];
    int front;
    int rear;
    int size;

    QueueArray(int size) {
        list = new Node[size];
    }

    public void enqueue(int data) {
        if (rear == list.length ) {
            System.out.println("the list is full");
            return;
        }
        list[rear] = new Node(data);
        rear++;
        this.size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        list[front] = null;
        front++;
        this.size--;
        if (isEmpty()) {
            front = rear = 0;
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
        for (int i = front; i < rear; i++) {
            System.out.println(list[i]);
        }

    }

    public boolean isEmpty() {
        return (rear - front) == 0;
    }

}
