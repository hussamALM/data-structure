
package algorithm;

public class StackArray {
    
    Node[] list;
    int top;
    int size;

    StackArray(int size) {
        list = new Node[size];
    }

    public void push(int data) {

        if (isFull()) {
            System.out.println("the list is full");
            return;
        }
        Node node = new Node(data);
        list[top++] = node;
        this.size++;

    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        --top;
        list[top] = null;
        this.size--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        System.out.println(list[top - 1]);

    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == list.length;
    }

    public void size() {
        System.out.println("the size is: " + this.size);
    }

    public void displayList() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(list[i]);
        }
    }
    
}
