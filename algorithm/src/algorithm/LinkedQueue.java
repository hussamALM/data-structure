package algorithm;

public class LinkedQueue {
    Single_linkedList list;

    LinkedQueue() {
        list = new Single_linkedList();
    }

    public void Enqueue(int data) {
        list.insertLast(data);
        curInfo();
    }

    public void Dequeue() {
        list.DeleteFirst();
        curInfo();
    }

    public void Top() {
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
        list.size();
    }
    public void curInfo (){
    list.DisplayList();
    list.size();
    }
}
