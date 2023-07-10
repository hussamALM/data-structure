package algorithm;

public class LinkedStack {

    Single_linkedList list;

    LinkedStack() {
        list = new Single_linkedList();
    }

    public void push(int data) {
        list.insertFirst(data);
        curInfo();
    }

    public void pop() {
        list.DeleteFirst();
        curInfo();
    }

    public void peek() {
        list.DisplayFirst();
        size();
    }

    public void isEmpty() {
        if (list.isEmpty()) {
            System.out.println("the list is empty");
        } else {
            System.out.println("the list isn't empty");
        }

    }

    public void size() { 
        System.out.println(list.size);
    }

    public void curInfo() {
        list.DisplayList();
        list.size();
    }
}
